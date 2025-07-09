#include <iostream>
#include <cmath> //for ceil()
using namespace std;

//Constants
const float GALLONS_PER_SQFT = 1.0f / 110;
const float LABOR_HOURS_PER_SQFT = 8.0f / 110;
const float LABOR_COST_PER_HOUR = 25.0f;

//Function to get the number of rooms to paint
int getRooms() {
    int rooms;
    cout << "Enter the number of rooms to paint: ";
    cin >> rooms;

  while (cin.fail() || rooms <= 0) {
        cin.clear();
        cin.ignore(1000, '\n');
        cout << "Invalid input. Please enter a number greater than or equal to 1: ";
        cin >> rooms;
    }
    return rooms;
    }

//Function to get the square footage of a room
float getSquareFootage(int roomNumber) {
    float squareFootage;
    cout << "Enter the square footage of room # " << roomNumber << ": ";
    cin >> squareFootage;

   while (cin.fail() || squareFootage <= 0) {
        cin.clear();
        cin.ignore(1000, '\n');
        cout << "Invalid input. Please enter a number greater than 0: ";
        cin >> squareFootage;
        }
    return squareFootage;
    }
//Funtion to calculate the cost of paint per gallon
float getPricePerGallon(int roomNumber) {
    float price;
    cout << "Enter the price per gallon of paint for room # " << roomNumber << ": ";
   cin>> price;

  while (cin.fail() || price <= 10.0) {
        cin.clear();
        cin.ignore(1000, '\n');
        cout << "Invalid input. Please enter a number greater than or equal to $10.00: ";
        cin >> price;

}
return price;
}
//Function to calculate the gallons of paint needed for a room
int gallonsForRoom(float squareFootage) {
    return ceil(squareFootage * GALLONS_PER_SQFT);
    }
//Function to display final estimate
void displayEstimate(float paintCharge, int totalGallons, float laborCharge, float laborHours) {
  cout << "\n--- Paint Job Estimate ---" << endl;
  cout << "Gallons of paint required: " << totalGallons << endl;
  cout << "Hours of labor required: " << laborHours << endl;
  cout << "Cost of paint: $" << paintCharge << endl;
  cout << "Labor charges: $" << laborCharge << endl;
  cout << "Total cost: $" << paintCharge + laborCharge << endl;
  }

//Main program
int main() {
  float paintCharge = 0.0;
  float laborCharge = 0.0;
  float laborHours = 0.0;
  int totalGallons = 0;

  cout << "Welcome to the Paint Job Estimator!\n";

  int rooms = getRooms();

  for (int i = 1; i <= rooms; i++) {
    float squareFootage = getSquareFootage(i);
    int gallons = gallonsForRoom(squareFootage);
    float pricePerGallon = getPricePerGallon(i);

    float roomPaintCost = gallons * pricePerGallon;
    float roomLaborHours = squareFootage * LABOR_HOURS_PER_SQFT;
    float roomLaborCost = roomLaborHours * LABOR_COST_PER_HOUR;

    totalGallons += gallons;
    paintCharge += roomPaintCost;
    laborHours += roomLaborHours;
    laborCharge += roomLaborCost;
    }

   displayEstimate(paintCharge, totalGallons, laborCharge, laborHours);
    return 0;
    }
