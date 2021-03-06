/*
 * JRobo - An Advanced IRC Bot written in Java
 *
 * Copyright (C) <2013> <Christopher Lemire>
 * Copyright (C) <2013> <BinaryStroke>
 * Copyright (C) <2013> <Muhammad Sajid>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 */
package jrobo;

/**
 *
 * @author n0per
 *
 */
public class WeatherJson {

    private WeatherJson.CurrentObservation current_observation;

    public class CurrentObservation {

        private String temperature_string;
        private String weather;
        private WeatherJson.ObservationLocation observation_location;
        private DisplayLocation display_location;

        @Override
        public String toString() {
            return (temperature_string + " - " + weather);
        }

        public String getTemperatureString() {
            return temperature_string;
        }

        public String getWeather() {
            return weather;
        }

        public WeatherJson.ObservationLocation getObservationLocation() {
            return observation_location;
        }

        public DisplayLocation getDisplayLocation() {
            return display_location;
        }
    }

    public class ObservationLocation {

        private String country;


        /*
         * public String getCity() { return city;
        }
         */
        public String getCountry() {
            return country;
        }

        /*
         * public String getState() { return state;
        }
         */
        @Override
        public String toString() {
            return country;
        }
    }

    public class DisplayLocation {

        private String full;
        private String city;
        private String state;

        @Override
        public String toString() {
            return full;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }
    }

    public String getTemperatureString() {
        return current_observation.getTemperatureString();
    }

    public String getWeather() {
        return current_observation.getWeather();
    }

    public String getCountry() {
        return current_observation.getObservationLocation().getCountry();
    }

    public String getCity() {
        return current_observation.getDisplayLocation().getCity();
    }

    public String getState() {
        return current_observation.getDisplayLocation().getState();
    }

    @Override
    public String toString() {
        if(current_observation != null) {
        if (!getState().equals("")) {
            return String.format("Weather for %s, %s, %s: is %s - %s",
                    getCity(), getState(), getCountry(), getTemperatureString(), getWeather());
        } else {
            return String.format("Weather for %s, %s: is %s - %s",
                    getCity(), getCountry(), getTemperatureString(), getWeather());
        }

    }
        return "Unable to retrieve weather";
    }
}
