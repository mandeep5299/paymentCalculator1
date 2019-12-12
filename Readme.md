# Discount calculator
Check the discount applicable on consumables and let user know the payable amount.

## Usage
1. Run application as java application from PaymentCalculator class.
2. application will ask for the various inputs.
3. Enter bill amount.
	Bill amount must be greater than 0. If amount is 0 or less than 0, application will exit, then repeat step 1.
4. Enter - Is grocery bill? (Y/N)
	Provide string input as Y for yes if it is grocery bill check, anything other string will be consider as NO.
5. Enter - Is an employee? (Y/N)
	Provide string input as Y for yes if the bill is for customer or employee, anything other string will be consider as NO.
6. Enter - Is an affiliate? (Y/N)
	Provide string input as Y for yes if the bill is for affiliate or employee, anything other string will be consider as NO.
7. Enter - Customer since year.
	Provide year for association. Only year is needed as input. Year must be greater than 0 or less than equal to current year. 	Any other value will be consider as invalid input.
8. Discount will be calculated based on the inputs. Applicable discount and payable amount will be displayed to user.
	Maximum applicable discount will be applied.