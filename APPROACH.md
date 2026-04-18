# Coding Exercise

### Approach

### Objective

Classify packages based on their dimensions and mass to determine the appropriate stack for dispatching.
Stack categories:
- **STANDARD**: Packages that are neither bulky nor heavy.
- **SPECIAL**: Packages that are either bulky or heavy, but not both.
- **REJECTED**: Packages that are both bulky and heavy.

### Rules
- A package is **bulky** if:
  - Volume (Width x Height x Length) >= 1,000,000 cm³
  - OR any dimension (Width, Height, Length) >= 150 cm
- A package is **heavy** if:
  - Mass >= 20 kg

### Implementation
Break down the problem into steps:
1. The classification depends on two independent conditions: whether the package is bulky and whether it is heavy. 
We can determine these conditions separately and then combine the results to classify the package.

2. Determine if package is bulky:
   - Calculate volume: `volume = width * height * length`
   - Check if `volume >= 1,000,000` OR if any dimension is >= 150 cm.
   - to simplify dimension check, we can use `Math.max(width, Math.max(height, length)) >= 150`

3. Determine if package is heavy:
   - Check if `mass >= 20`

4. Apply the classification logic:
   - If both bulky and heavy: return "REJECTED"
   - If either bulky or heavy (but not both): return "SPECIAL"
   - If neither bulky nor heavy: return "STANDARD"

### Implementation Strategy:
1. Use helper methods isBulky and isHeavy to determine the conditions for bulky and heavy packages.
2. use long for volume calculation to avoid overflow issues with large dimensions.
3. Implement the main method sort to classify the package based on the results from the helper methods

### Edge Cases:
- boundary values for dimensions and mass (e.g., exactly 1,000,000 cm³, exactly 20 kg)
- very large dimensions that could cause overflow if not handled properly (use long for volume)
- packages that are just below the thresholds to ensure correct classification (e.g., 999,999 cm³, 19.9 kg)
- invalid inputs (e.g., negative dimensions or mass) - depending on requirements, we could either throw an exception or classify them as "REJECTED" since they don't meet valid criteria.

### Test Cases:
1. **Standard Package**: `sort(10, 10, 10, 5)` should return "STANDARD"
2. **Bulky Package**: `sort(100, 100, 100, 5)` should return "SPECIAL"
3. **Heavy Package**: `sort(10, 10, 10, 25)` should return "SPECIAL"
4. **Rejected Package**: `sort(100, 100, 100, 25)` should return "REJECTED"
5. **Boundary Case for Bulky**: `sort(100, 100, 100, 19)` should return "SPECIAL"
6. **Boundary Case for Heavy**: `sort(10, 10, 10, 20)` should return "SPECIAL"
7. **Bulky by Dimension**: `sort(150, 1, 1, 1)` should return "SPECIAL"
8. **Rejected by Dimension**: `sort(150, 1, 1, 20)` should return "REJECTED"
9. **Invalid Input**: `sort(-10, 10, 10, 5)` should return "REJECTED" (or throw an exception based on implementation choice)
