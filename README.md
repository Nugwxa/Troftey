# Troftey App

Android App for providing historical facts about user's country

## Project Description

This project aims to create an Android app that provides the user with historical facts about their country by retrieving the user's current country using their device's GPS coordinates. The app has a button that, when pressed, obtains the user's GPS coordinates, converts them to a country name, and displays the country name along with a random fact in the text view.

The app uses the Android LocationManager class to access the device's GPS data, and the Geocoder class to convert the GPS coordinates to a country name. Additionally, the app implements error handling to ensure that it can handle cases where there is no internet connection.


## Screenshots

<div style="display:flex;">
  <img src="https://i.ibb.co/vqGwLNt/troftey-home.jpg" alt="Home Screen" height="400"/>
  <img src="https://i.ibb.co/T451zmp/troftey-uk.jpg" alt="UK" height="400"/>
  <img src="https://i.ibb.co/1MH6mGg/troftey-chechia.jpg" alt="Czechia" height="400"/>
</div>

## Technologies Used

- Java
- Android LocationManager class
- Geocoder class

## How to Use

To use this app, simply install it on your Android device and enable location permissions. Then open the app click the "Get Country" button to retrieve your current country, The app will then display your country name in the text view, then click the "Get Facts" button to get facts about your country. 

## Code Description

The code is written in Java and includes a getCountryName method that is called when the button is pressed. The method uses the Geocoder class to convert the GPS coordinates to a country name, and the LocationManager class to access the device's GPS data. The method also implements error handling to handle cases where there is no internet connection. The facts in this project are stored in a string array resource file and the MainActivity.java file contains code to retrieve a random fact from the array when the button is clicked. The fact is then displayed using the textView.

## Contributions

Contributions to this project are welcome. If you would like to contribute, please follow the standard procedures for GitHub pull requests.

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
