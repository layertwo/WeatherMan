package me.fromgate.weatherman.localweather;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherStateTest {

    @Test
    void getByName_returnsRain_forLowercase() {
        assertEquals(WeatherState.RAIN, WeatherState.getByName("rain"));
    }

    @Test
    void getByName_returnsRain_forUppercase() {
        assertEquals(WeatherState.RAIN, WeatherState.getByName("RAIN"));
    }

    @Test
    void getByName_returnsClear_forLowercase() {
        assertEquals(WeatherState.CLEAR, WeatherState.getByName("clear"));
    }

    @Test
    void getByName_returnsClear_forUppercase() {
        assertEquals(WeatherState.CLEAR, WeatherState.getByName("CLEAR"));
    }

    @Test
    void getByName_returnsUnset_forNull() {
        assertEquals(WeatherState.UNSET, WeatherState.getByName(null));
    }

    @Test
    void getByName_returnsUnset_forUnrecognizedString() {
        assertEquals(WeatherState.UNSET, WeatherState.getByName("stormy"));
    }

    @Test
    void getByName_returnsUnset_forEmptyString() {
        assertEquals(WeatherState.UNSET, WeatherState.getByName(""));
    }
}
