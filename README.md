# SWLibrary
A library to access the https://swapi.dev/ API


## Description

The main purpose of this library is to handle an API call to https://swapi.dev/api/ and to allow a user to use the data from the response. In making the different categories, 
I felt it was more practical to make a call to retrieve the whole list of objects in a category rather than trying to make a separate call for each item in a list (or a call to get the number of items and then a call to get an item's attributes). I then tried to make the API call as ubiquitous as possible to avoid having to repeat code for separate calls, so the current version makes a call to different endpoints based on a parameter String which is passed in. The data from the endpoint is then parsed into one of several category classes I created to hold the attributes from the end point (such as name and eye color for a Person). Accessing the data is then handled by a Callback interface, which the user implements in their activity.

###
Sample app here:
This sample app uses simple buttons to navigate between pages. The category pages themselves use RecyclerView to dynamically display the list of objects that is received from the API call. Clicking on an item opens the InfoDialog Activity as a dialog which displays the item's information

### Objects
* APICall.kt - this sets up the main Volley request to the API. Through Volley, a jsonObjectRequest is created and added to a RequestQueue. The response is parsed into the separate categories depending on what the user requested. The resulting ArrayList is then passed to VCallback so that its data can be accessed synchronously. 

### Interfaces
* VCallback.kt - this allows the data to be used in the class/activity calling it

### Categories
Each category corresponds to an endpoint in the swapi.dev API. Each stores several attributes of that category, and can return them as Strings 
* Person.kt - corresponds to the https://swapi.dev/api/people/ endpoint
* Planet.kt - corresponds to the https://swapi.dev/api/planets/ endpoint
* Films.kt - corresponds to the https://swapi.dev/api/films/ endpoint
* Species.kt - corresponds to the https://swapi.dev/api/species/ endpoint
* Starships.kt - corresponds to the https://swapi.dev/api/starships/ endpoint
* Vehicles. kt - corresponds to the https://swapi.dev/api/vehicles/ endpoint

### Future work
There is still some repetitive code - especially concerning creating objects of the right types - that I would like to reduce. Additionally, I'd like to explore accessing all the pages of a category from swapi.dev, as a page result from the API accesses only 10 results at a time. Finally, I'd like to implement a few more things to the sample app to make it more dynamic and interactive, such as photos/animations, or music that plays (especially for the opening crawls!) 

## Getting Started

### Dependencies

* In your project's root build.gradle file add the jitpack repository:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
* In the app build.gradle, under 'dependencies' add
```
implementation 'com.github.SuperiorNyx:SWLibrary:0.0.5'
```

### Usage
* **APICall.loadInfo(c: Context?, category: String, vCallback: VCallback)**: This is the main method which sets up the api call to swapi.dev
   *  c: the context of the application which is calling this method, needed for the Volley ResponseQueue
   *  category: the particular category (people, starships, films, planets, vehicles, species) that the user wants
   *  vCallback: this utilizes the VCallback interface so that the data can be accessed 
   *  **Result**: An ArrayList is created from the json array... this is cast as type Any at first, but can be cast as any of the category classes (Person, Film, Planet, etc) when implementin vCallback.onSucess
   *  **Example** in an activity:
```
resultsList = arrayListOf<Planet>()
APICall.loadInfo(this, "planets", object : VCallback {
            override fun onSuccess(result: ArrayList<Any>?) {
                resultsList = result as ArrayList<Planet>
                Toast.makeText(this, resultsList!![0].getPlanetName, Toast.LENGTH_SHORT).show()
            }
        })
```

## Authors

Rebecca Nicacio

## Version History

* 0.0.5
    * Fixed inconsistency in APICall  
* 0.0.1
    * Initial Release

