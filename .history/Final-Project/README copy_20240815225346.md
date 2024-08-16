Weather App
Overview
The Weather App is a Java Swing-based graphical user interface application that retrieves and displays current weather data for a given location. The app features real-time weather information including temperature, weather conditions, humidity, and windspeed. Users can search for weather data by entering a location and selecting their preferred units for temperature and windspeed.

Features
Search for Weather Data: Enter a location to get current weather information.
Display Weather Information: View temperature, weather conditions, humidity, and windspeed.
Unit Conversion: Choose between Celsius and Fahrenheit for temperature, and km/h or mph for windspeed.
Dynamic Weather Icons: Displays icons based on current weather conditions (e.g., Clear, Cloudy, Rain, Snow).
Prerequisites
Java Development Kit (JDK) 8 or later
Internet access for API requests
Setup Instructions
Clone the Repository:

bash
git clone https://github.com/weather-app.git
Navigate to the Project Directory:

bash
Copy code
cd weather-app
Compile the Code:
Ensure that you have javac in your PATH. Compile the Java files using:

`
    javac -d bin src/**/*.java`
    Run the Application:
To run the application, execute:

`
java -cp bin AppLauncher
API Integration`
The application uses the following APIs:

Geocoding API: For retrieving geographic coordinates based on the location name.

Endpoint: https://geocoding-api.open-meteo.com/v1/search
Weather API: For fetching weather data using geographic coordinates.

Endpoint: https://api.open-meteo.com/v1/forecast
File Structure
src/: Contains all source Java files.
WeatherApp.java: Handles weather data retrieval and processing.
WeatherAppGui.java: Contains the GUI components and functionality.
AppLauncher.java: Entry point of the application.
assets/: Contains image files used in the GUI.
clear.png: Icon for clear weather.
cloudy.png: Icon for cloudy weather.
rain.png: Icon for rainy weather.
snow.png: Icon for snowy weather.
humidity.png: Icon for humidity.
windspeed.png: Icon for windspeed.
search.png: Icon for the search button.
Troubleshooting
API Errors: Ensure that the API endpoints are correct and accessible. Check network connectivity.
Compilation Issues: Make sure Java is correctly installed and javac is available in your PATH.
Contributing
Feel free to fork the repository, make changes, and submit pull requests. Contributions are welcome!

License
This project is licensed under the MIT License - see the LICENSE file for details.

Contact
For any questions or issues, please contact [your email address].

Feel free to adjust any sections or details as needed