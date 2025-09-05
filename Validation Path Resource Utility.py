Import pandas as pd
import os

# Input file path (CSV or Excel)
input_file = "C:/Users/omkar.naik/Downloads/output.csv"   # Change this to your file (input.csv OR input.xlsx)

# Detect file type
file_ext = os.path.splitext(input_file)[1].lower()

# Read file depending on extension
if file_ext == ".csv":
    df = pd.read_csv(input_file)
elif file_ext in [".xls", ".xlsx"]:
    df = pd.read_excel(input_file)
else:
    raise ValueError("Unsupported file type. Please provide a CSV or Excel file.")

print("Columns in input file:", df.columns.tolist())
print("Number of rows:", len(df))

if "resource" not in df.columns:
    print("ERROR: 'resource' column not found in input file.")
    exit(1)

if df.empty:
    print("ERROR: Input file is empty.")
    exit(1)

# Define your primary and secondary base paths
primary_base_paths = [
    "C:/Users/omkar.naik/Core Projects/CoreSuite-14.2@/coresuite-14.2/PL/resources/src/main/resources/webapp/WEB-INF/views",
    "C:/Users/omkar.naik/Core Projects/CoreSuite-14.2@/coresuite-14.2/PL/resources/src/main/resources/webapp/WEB-INF/uk/views",
    "C:/Users/omkar.naik/Core Projects/Wesleyan-14.2@/wesleyan-14.2/PL/resources/src/main/resources/wesleyan-webapp/WEB-INF/views",
    "C:/Users/omkar.naik/Core Projects/CoreSuite-14.2@/coresuite-14.2/Web_Designer/DesignerPL/resources/src/main/resources/ct-webapp/WEB-INF/views",
    "C:/Users/omkar.naik/Core Projects/Wesleyan-14.2@/wesleyan-14.2/Web_Designer/DesignerPL/resources/src/main/resources/ct-wesleyan-webapp/WEB-INF/views"
]

secondary_base_paths = [
    "C:/Users/omkar.naik/Core Projects/Wesleyan-Core-Cust-V6.6.2-29/Wesleyan-Core/PL/US/view/src/main/webapp/WEB-INF/views",
    "C:/Users/omkar.naik/Core Projects/Wesleyan-Core-Cust-V6.6.2-29/Wesleyan-Core/PL/US/view/src/main/webapp/WEB-INF/uk/views",
    "C:/Users/omkar.naik/Core Projects/Wesleyan-Core-Cust-V6.6.2-29/Wesleyan-Cust/PL/src/main/webapp/WEB-INF/views"
]

# Initialize counters
cond1_count = 0  # Empty Resource
cond2_count = 0  # View/field matches found in Core V14.2 OR Wesleyan V14.2
cond3_count = 0  # View/field matches not found in any versions (V6.2 & V14.2 Core & Cust) - Can be considered as deprecated
cond4_count = 0  # Found in (V6.2) but not in V14.2 - Needs review (Manual Intervention required)

def check_paths(resource):
    global cond1_count, cond2_count, cond3_count, cond4_count
    if pd.isna(resource) or str(resource).strip() == "" or str(resource).strip() == "/views":
        cond1_count += 1
        return "Empty Resource", ""

    resource = str(resource).strip()
    if not resource.startswith("/views/"):
        cond3_count += 1
        return "Not a /views/ resource", ""

    # Remove leading slash and split
    parts = resource.lstrip("/").split("/")
    if len(parts) < 2:
        cond3_count += 1
        return "Malformed resource value", ""

    last_part = parts[-1]
    parent_folder = parts[-2]
    full_label = f"{parent_folder}.{last_part}"

    # 1. Check in primary_base_paths
    found_view = False
    found_paths = []
    for base in primary_base_paths:
        view_path = os.path.join(base, *parts[1:])  # skip 'views'
        if os.path.isdir(view_path):
            found_view = True
            found_paths.append(base)
    if found_view:
        cond2_count += 1
        return f"View exists in: {', '.join(found_paths)}", "Path matches"

    found_field = False
    for base in primary_base_paths:
        parent_dir = os.path.join(base, *parts[1:-1])
        spml_path = os.path.join(parent_dir, "spml.xml")
        if os.path.isfile(spml_path):
            try:
                with open(spml_path, "r", encoding="utf-8") as f:
                    content = f.read()
                    if last_part in content or full_label in content:
                        found_field = True
                        cond2_count += 1
                        return f"Field '{last_part}' or '{full_label}' found in {spml_path}", f"Field found at the path {spml_path}"
            except Exception as e:
                cond3_count += 1
                return f"Error reading {spml_path}: {e}", ""

    # 2. If not found in primary, check in secondary_base_paths
    found_view_secondary = False
    found_paths_secondary = []
    for base in secondary_base_paths:
        view_path = os.path.join(base, *parts[1:])
        if os.path.isdir(view_path):
            found_view_secondary = True
            found_paths_secondary.append(base)
    if found_view_secondary:
        cond4_count += 1
        return (
            f"Found in V6.2: View exists in {', '.join(found_paths_secondary)} but not present in V14.2",
            "View exists in V6.2 but not in V14.2"
        )

    found_field_secondary = False
    for base in secondary_base_paths:
        parent_dir = os.path.join(base, *parts[1:-1])
        spml_path = os.path.join(parent_dir, "spml.xml")
        if os.path.isfile(spml_path):
            try:
                with open(spml_path, "r", encoding="utf-8") as f:
                    content = f.read()
                    if last_part in content or full_label in content:
                        found_field_secondary = True
                        cond4_count += 1
                        return (
                            f"Found in V6.2: Field '{last_part}' or '{full_label}' found in {spml_path} but not present in V14.2",
                            "Field exists in V6.2 but not in V14.2"
                        )
            except Exception as e:
                cond3_count += 1
                return f"Error reading {spml_path}: {e}", ""

    # 3. Not found in either: deprecated
    cond3_count += 1
    return "Not found in any base path", "Deprecated in V6.2"

# Apply function and unpack results
try:
    df[["Remarks", "Comments"]] = df["resource"].apply(lambda x: pd.Series(check_paths(x)))
except Exception as e:
    print(f"ERROR while applying check_paths: {e}")
    exit(1)

# Print condition counts AFTER applying the function
print(f"Condition 1 count (Empty Resource): {cond1_count}")
print(f"Condition 2 count (View/field matches found in V14.2): {cond2_count}")
print(f"Condition 4 count (Manual Intervention * Found in V6.2 but not in V14.2): {cond4_count}")
print(f"Condition 3 count (Deprecated Items * Not found in any versions): {cond3_count}")

# Count records found via "Path matches"
path_matches_count = (df["Comments"] == "Path matches").sum()

# Count records found via "Field found at the path"
field_found_count = df["Comments"].str.startswith("Field found at the path").sum()

# Count records found via V6.2
v62_view_count = (df["Comments"] == "View exists in V6.2 but not in V14.2").sum()
v62_field_count = (df["Comments"] == "Field exists in V6.2 but not in V14.2").sum()
print(f"Records found via 'Path matches in V14.2': {path_matches_count}")
print(f"Records found via 'Field found at the path in V14.2': {field_found_count}")
print(f"Records found via 'View exists in V6.2 but not in V14.2': {v62_view_count}")
print(f"Records found via 'Field exists in V6.2 but not in V14.2': {v62_field_count}")

# Create output directory if it doesn't exist
output_dir = "C:/Users/omkar.naik/Downloads/ProcessedOutput"
os.makedirs(output_dir, exist_ok=True)
output_file = os.path.join(output_dir, f"Validations_filtered_list{file_ext}")

# Save depending on type
try:
    if file_ext == ".csv":
        df.to_csv(output_file, index=False)
    else:  # Excel
        df.to_excel(output_file, index=False)
except Exception as e:
    print(f"ERROR while saving output file: {e}")
    exit(1)

# Save Condition 4 (Found in V6.2) records to a separate Excel file
cond4_df = df[df["Comments"].isin([
    "View exists in V6.2 but not in V14.2",
    "Field exists in V6.2 but not in V14.2"
])]
cond4_output_file = os.path.join(output_dir, f"Manual_intervention_required_Found_in_V6.2_only.xlsx")
cond4_df.to_excel(cond4_output_file, index=False)
print(f"Condition 4 records saved at: {cond4_output_file}")

# Save Condition 3 (Not found in any) records to a separate Excel file
cond3_df = df[df["Comments"] == "Deprecated in V6.2"]
cond3_output_file = os.path.join(output_dir, f"Deprecated_in_V6.2.xlsx")
cond3_df.to_excel(cond3_output_file, index=False)
print(f"Condition 3 records saved at: {cond3_output_file}")

# Print absolute path of output file and counts
output_abs_path = os.path.abspath(output_file)
print(f"Process completed. New file saved at: {output_abs_path}")