document.getElementById("searchBtn").addEventListener("click", getWeather);

async function getWeather() {
  const city = document.getElementById("cityInput").value;
  if (!city) {
    alert("Please enter a city");
    return;
  }

  try {
    const res = await fetch(`http://localhost:8080/api/weather?city=${city}`);
    if (!res.ok) {
      alert("City not found");
      return;
    }
    const data = await res.json();

    document.getElementById("weatherCard").style.display = "block";
    document.getElementById("cityName").innerText = data.name;
    document.getElementById("description").innerText = data.weather[0].description.toUpperCase();
    document.getElementById("temperature").innerText = data.main.temp + " °C";
    document.getElementById("extra").innerText =
      "Humidity: " + data.main.humidity + "% | Wind: " + data.wind.speed + " m/s";
  } catch (error) {
    console.error("Error fetching weather:", error);
    alert("Error fetching weather data");
  }
}
