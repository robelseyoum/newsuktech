
# Android News UK Application
- Shows a list of coins and the details of each coin.

# The tech stack and the architecture used are:
- Clean Architecture with 3 Layers Architecture, "Presentation Layer", "Domain Layer" and "Data Layer" and MVVM pattern with Kotlin
- Dagger-Hilt for Dependency Injection
- Jetpack Compose UI tools
- MockK for Unit testing
- Coroutine (Kotlin flows)for background UI thread processing data
- Main Jetpack Components including ViewModel

---
- Showing the list of coins and the details of each coin.
<p align="center">
  <img src="coins_list.png" alt="List of Coins" width="220" height="480"/>

  <img src="coin_detail.png" alt="Coins Details" width="220" height="480"/>
</p>

- If there is error so get the list of coins and the details of each coin.
<p align="center">
  <img src="coin_list_error.png" alt="Errror for List of Coins" width="220" height="480"/>

  <img src="detail_error.png" alt="Error Coins Details" width="220" height="480"/>
</p>
