#!/bin/bash

cat << EOF > README.md
# Weather App

## Overview

The Weather App is a Java Swing-based graphical user interface application that retrieves and displays current weather data for a given location. The app features real-time weather information including temperature, weather conditions, humidity, and windspeed. Users can search for weather data by entering a location and selecting their preferred units for temperature and windspeed.

## Features

- **Search for Weather Data**: Enter a location to get current weather information.
- **Display Weather Information**: View temperature, weather conditions, humidity, and windspeed.
- **Unit Conversion**: Choose between Celsius and Fahrenheit for temperature, and km/h or mph for windspeed.
- **Dynamic Weather Icons**: Displays icons based on current weather conditions (e.g., Clear, Cloudy, Rain, Snow).

## Prerequisites

- Java Development Kit (JDK) 8 or later
- Internet access for API requests

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/sheshbazzarr/java.git
