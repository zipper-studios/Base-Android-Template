# Base-Android-Template
This project is a structured template for an Android app that can be used as a starting point to create your own apps.


## Introduction
If you want to start an Android project with a <b><i>clean architecture, reactive programming integration with Coroutines, Room database usage, Retrofit integration, Locale changer and other basic concepts used in any Android application</i></b>, this code is what you need.

To prove the mentioned concepts, the full-screen <b>Base-Android-Template</b> application contains a BotttomNavigationView with two sections:
- <b>Github Users</b> is an interactive screen animated using the MotionLayout component. This screen displays a list of Github users fetched from the local Room database. If database does not contain users, the list will be retrieved from the server and then saved in Room. 
- <b>Settings</b> is the screen where you can switch from Romanian and English languages. Here you can understand how simple and intuitive the Android Locale configurations can be changed.

## Documentation

<h4>MVVM Clean Architecture</h4>
The code has been structured following the Clean Architecture approach and the Model-View-View-Model (MVVM) pattern.

<h4>App bolierplate</h4>

The main goal of this application is to avoid writing app basic boilerplate code, so the base classes for Fragment and ViewModel are already implemented:

1. <b>BaseFragment</b> - receives the corresponding ViewDataBinding and ViewModel generic types and the id of the layout to be inflated. It avoids the boilerplate code because:
   - inflates the corresponding layout using DataBinding;
   - set the layout databinding variables;
   - observes navigation commands from ViewModel and perform navigation;
   - observes loading commands and shows/hides the loading progress bar;
   - observes the messages and displays them in a Toast.
2. <b>BaseViewModel</b> - contains public methods that can be called from all ViewModels in the hierarchy to send commands to the BaseFragment to:
   - navigate between fragments via Navigation component;
   - display messages;
   - show/hide loading progress bar.

<h4>Dependency Injection</h4>

Dependency Injection is used on the app basically to make the components decoupled and reusable and to make testing easier. The library used to achieve that is [Koin](https://github.com/InsertKoinIO/koin)

<h4>Reactive Programming</h4>

Clean architecture makes you create different layers and, in order to avoid a callback hell, reactive programming paradigm is applied using [Coroutines](https://developer.android.com/kotlin/coroutines?gclid=Cj0KCQjwi7yCBhDJARIsAMWFScPxNPy-8e1PKDYuTjaNH5IQsqoGgT7P99aYP39EJdUJyYgQeypcIBIaAvmAEALw_wcB&gclsrc=aw.ds).

<h4>Libraries used</h4>

- DataBinding - allows to bind UI components in the layouts to data sources using a declarative format
- Navigation Component - helps implement navigation, from simple button clicks to more complex patterns, such as app bars and the navigation drawer
- Room - provides an abstraction layer over SQLite to allow fluent database access 
- Coroutine - help to manage long-running tasks that might otherwise block the main thread and cause the app to become unresponsive
- Calligraphy - used to set fonts on different text views in the app
- Hawk - is a secure and simple key-value storage for Android
- Koin - brings easy dependency injection to Android
- Retrofit - a type-safe HTTP client for Android.
