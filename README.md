# ProductionLineTrackerProject

## 

Problem Statement

**Scenario**

You have been hired to create software for a media player production facility that will keep track of what products are produced.

Without the software, workers on the production floor are physically producing items and having to write down what is produced in a production log book.

Management would like the production tracking to be more automated so the workers don't need to spend as much time recording what was produced, the log will be more accurate, and it will be easier to generate production reports.

In addition to the ability to record production, the software also needs the ability to add to the product line (the catalog of products that are able to be produced).

-   **Goals** (high level intended outcomes; for software, a Product Backlog)
    -   Hypothetical / Real world
        1.  Allow a user to add new products that are able to be produced and store them in a collection.
        2.  The collection of products that can be produced can be displayed at any time.
        3.  Allow a user to track production of products, including specifying how many items of that product were created. The program will then create a record for each of these items and store them in a collection.
        4.  The collection of created items can be displayed at any time.
        5.  Production statistics can be displayed – Total items produced, number of each item type, the number of unique products created etc.
        6.  Employee accounts can be made.
        7.  Allow easy modification to handle different products.
    -   Actual / For class
        1.  Solidify understanding of object oriented programming.
        2.  Practice Java.
        3.  Learn basic graphical user interface (GUI) programming.
        4.  Learn basic database programming.
-   **Boundaries / Scope** (where the functions and responsibilities of the solution start and end / what it should do and what is left to other systems to do)
    -   Hypothetical / Real world
        -   For this particular production facility you will only need to track music and movie players.
        -   The program does not need the ability to place or fulfill orders / reduce stock, just track production.
    -   Actual / For class
        -   TBD
-   **Success criteria** (set of conditions to be satisfied at completion; must be measurable and verifiable, like a test)
    -   Hypothetical / Real world
        -   Pass tests (in repl.it)
        -   Follow rules for documentation, style, and coding conventions
    -   Actual / For class
        -   Grading forms / rubrics (in Canvas)
            -   Documentation (see below)
            -   Style (see below)
            -   Quality (see below)
            -   Assignment Specifications - include full project in your repository so your program can be easily imported and run.
        -   Creation of artifact for portfolio
-   **Constraints** (externally imposed limitations on system requirements, design, or implementation or on the process used to develop or modify a system)
    -   Hypothetical / Real world
        -   The program will be a GUI database program written in Java.
        -   The program must be flexible to allow for future expansion.
        -   Code should be saved to a private GitHub repository.
        -   Follow best practices for style, documentation, and quality.
    -   Actual / For class
        -   Communication and collaboration with classmates is allowed but should not extend to sharing actual code.
-   **Assumptions** (things that are accepted as true or as certain to happen, without proof)
    -   You like to program.
    -   You have foundational knowledge of programming from prerequisite courses.
    -   You will spend at least 4 hours per week on the project.
    -   The project should not require more than 7 hours per week. If so, contact the professor for assistance.
    -   This will help you be successful in future classes and your career.
-   **Stakeholders** (individuals or organizations having a right, share, claim, or interest in a system or in its possession of characteristics that meet their needs and expectations )
    -   Hypothetical / Real world
        -   CEO
        -   CTO
        -   CIO
        -   users
            -   production facility workers
            -   inventory managers
        -   customers
        -   I.T. support
    -   Actual / For class
        -   Yourself
        -   Future potential employers
        -   Professor
-   **Timelines** (a breakdown of the Product Backlog into time-bound smaller, more detailed tasks in Sprint Backlogs)
    -   Three 5-week sprints, detailed below.

## 

Sprint 1

_GUI, basic database_

**Week 1**

-   Create JavaFX project. See [IntelliJ](https://sites.google.com/site/profvanselow/software/intellij?authuser=0) page and [IntelliJ Help](https://www.google.com/url?q=https%3A%2F%2Fwww.jetbrains.com%2Fhelp%2Fidea%2Fpreparing-for-javafx-application-development.html&sa=D&sntz=1&usg=AFQjCNGfhsMWgBGucMqbhHbov50HxK9IPA)
-   Share to **private** repository on GitHub. See [GitHub](https://sites.google.com/site/profvanselow/programming/github?authuser=0) page.
-   Create README. Details in Documentation Expectations at bottom of page.

**Week 2**

-   Add a tab view with three tabs: Product Line, Produce, and Production Log
-   Add a CSS file with some code [Reference](https://www.google.com/url?q=https%3A%2F%2Fdocs.oracle.com%2Fjavafx%2F2%2Fapi%2Fjavafx%2Fscene%2Fdoc-files%2Fcssref.html&sa=D&sntz=1&usg=AFQjCNHwozleprI88eJmJ_g5YCFMQ7fETA) [Tutorial](https://www.google.com/url?q=https%3A%2F%2Fwww.callicoder.com%2Fjavafx-css-tutorial%2F&sa=D&sntz=1&usg=AFQjCNEbUK2NN76xn_DGRHacTF6avg3chg)
-   Quality expectations: see bottom of page
-   Style expectations: see bottom of page
-   Documentation expectations: see bottom of page

**Week 3**

-   In the Product Line tab
    -   In the AnchorPane
        -   Add a 2x3 GridPane
            -   Add a Label and text field for Product Name in row 0, columns 0 and 1
            -   Add a Label and text field for Manufacturer in row 1, columns 0 and 1
            -   Add a Label and ChoiceBox for Item Type in row 2, columns 0 and 1
        -   Add a Button that says Add Product
            -   Add an event handler to the button click event. For now, just have it print to the console (System.out.println)
        -   Add a Label and a Table View for Existing Products
-   In the Produce tab
    -   In the AnchorPane
        -   Add a Label and ListView for Choose Product
        -   Add a Label and ComboBox (data type String) for Choose Quantity
        -   Add a Button that says Record Production
            -   For now, just have the button print to the console (System.out.println)
-   In the Production Log tab
    -   In the AnchorPane
        -   Add a TextArea

**Week 4**

-   Install database software if necessary
-   Create database in a res folder at same level as src folder
    -   Similar to...

```
create table Product
```

```
(
```

```
  id int auto_increment,
```

```
  name varchar,
```

```
  type varchar,
```

```
  manufacturer varchar
```

```
);
```

  

```
create unique index Product_id_uindex
```

```
  on Product (id);
```

  

```
alter table Product
```

```
  add constraint Product_pk
```

```
    primary key (id);
```

  

```
create table ProductionRecord
```

```
(
```

```
 production_num int auto_increment,
```

```
 product_id int,
```

```
 serial_num varchar,
```

```
 date_produced datetime
```

```
);
```

-   Connect to database
    -   You will get a FindBugs error for not having a password or including the password. Eventually you will retrieve the password from another file but you don't need to worry about this for now.
-   Make sure to commit and push your res folder to the remote repository.

**Week 5**

-   Use a controller for almost all code.
-   In the Product Line tab, for the Add Product button event handler, add code to insert a product into the database
    -   You could hard code this statement (for now) or build from the user interface, like `INSERT INTO Product(type, manufacturer, name) VALUES ( 'AUDIO', 'Apple', 'iPod' );` See [JDBC - Insert Records Example](https://www.google.com/url?q=https%3A%2F%2Fwww.tutorialspoint.com%2Fjdbc%2Fjdbc-insert-records.htm&sa=D&sntz=1&usg=AFQjCNHuTo0mo6fnSqkICMWOAf1_-YINHQ)
    -   To avoid a FindBugs error, use a Prepared Statement. See [JDBC PreparedStatement](http://www.google.com/url?q=http%3A%2F%2Ftutorials.jenkov.com%2Fjdbc%2Fpreparedstatement.html&sa=D&sntz=1&usg=AFQjCNHudvfsvi60EPJ3NYo9vrUTh9wA1g)
    -   For now, every time a product is added to the database, output the full list of products to the console.
-   In the Produce tab, for the ComboBox
    -   Populate with values 1-10 in an [_initialize_ method](https://www.google.com/url?q=https%3A%2F%2Fdocs.oracle.com%2Fjavase%2F8%2Fjavafx%2Fapi%2Fjavafx%2Ffxml%2Fdoc-files%2Fintroduction_to_fxml.html%23controllers&sa=D&sntz=1&usg=AFQjCNG4hDHXzG52UWyZa9Qo9_EznSi24Q) in the Controller
    -   To allow the users to enter other values in the combobox, call the method `setEditable(true);`
    -   To show a default value, call the method `getSelectionModel().selectFirst();`
-   Prepare for submission

## 

Sprint 2

**Week 6 Enum, Interface, Abstract Class**

**Issue 1 - Product**

All items will have a pre-set type. Currently there are 4 types. Create an **enum** called ItemType that will store the following information:

_Type_

Audio

Visual

AudioMobile

VisualMobile

_Code_

AU

VI

AM

VM

-   See [Enum Types](https://www.google.com/url?q=https%3A%2F%2Fdocs.oracle.com%2Fjavase%2Ftutorial%2Fjava%2FjavaOO%2Fenum.html&sa=D&sntz=1&usg=AFQjCNEqSBXgT_50iDGl7XnYvKFMBKDmRQ) The Java™ Tutorials
-   In the Product Line tab
    -   Fill the ChoiceBox with the types. You can use an enhanced for loop or addAll. All the constants of an enum type can be obtained by calling the implicit public static T[] values() method.
    -   Update your code to insert a product to use the choice box selected item.

Create an **interface** called Item that will force all classes to implement the following functions:

-   A method getId that would return an int
-   A method setName that would have one String parameter
-   A method getName that would return a String
-   A method setManufacturer that would have one String parameter
-   A method getManufacturer that would return a String
-   See [Java - Interfaces](https://www.google.com/url?q=https%3A%2F%2Fwww.tutorialspoint.com%2Fjava%2Fjava_interfaces.htm&sa=D&sntz=1&usg=AFQjCNFgbby7R0aifb91_APeXmoW4s7HqA) tutorials point

Create an **abstract type** called Product that will implement the Item interface. Product will implement the basic functionality that all items on a production line should have. Add the following fields to Product

-   int id
-   String type
-   String manufacturer
-   String name

Complete the methods from the interface Item.

Add a constructor that will take in the name, manufacturer, and type of the product and set them to the field variables.

Add a toString method that will return the following: (example data shown).

```
Name: iPod
```

```
Manufacturer: Apple
```

```
Type: AM
```

To test the Product class, temporarily create a Widget class that extends Product. Store a created Widget object to the database and a productLine collection.

**Week 7 Inheritance**

**Issue 2 - AudioPlayer**

**MultimediaControl**

All of the items on this production line will have basic media controls. Create an interface called MultimediaControl that will define the following methods which don't need to return anything.

-   play()
-   stop()
-   previous()
-   next();

**AudioPlayer**

We require a concrete class that will allow us to capture the details of an audio player. Create a class called AudioPlayer that is a subclass of Product and implements the MultimediaControl interface.

The class will have 2 fields

-   String supportedAudioFormats
-   String supportedPlaylistFormats

Create a constructor that will take in 4 parameters – name, manufacturer, supportedAudioFormats, and supportedPlaylistFormats.

The constructor should call its parent's constructor and also setup the media type to AUDIO.

Implement the methods from the MultimediaControl interface by simply writing the action to the console.

E.g. in play `System.out.println("Playing");` Normally we would have code that would instruct the media player to play, but we will simply display a message.

Create a toString method that will display the superclass's toString method, but also add rows for supportedAudioFormats and supportedPlaylistFormats.

**Week 8 Polymorphism**

**Issue 3 - MultimediaControl**

**MonitorType**

The production facility will also create portable movie players. The main difference between these and the audio players is that they contain screens. Create an enum called MonitorType that will store

Type

LCD

LED

**ScreenSpec**

Create an interface called ScreenSpec. This will define 3 methods:

-   public String getResolution();
-   public int getRefreshRate();
-   public int getResponseTime();

**Screen**

Create a class called Screen that implements ScreenSpec. Add three fields

-   String resolution
-   int refresh rate
-   int response time

Complete the methods from the ScreenSpec interface.

Add a toString method that will return the details of the 3 fields in the same format as the Product class.

**MoviePlayer**

Create a class called MoviePlayer that extends Product and implements MultimediaControl.

Add 2 fields to this class called screen and monitorType and assign appropriate types to them.

Create a constructor that accepts the name, manufacturer, a screen, and a monitor type. The constructor can set the item type to VISUAL.

Complete the methods from the MultimediaControl interface in a similar fashion to the AudioPlayer.

Create a toString method that calls the Product toString and displays the monitor and the screen details.

**MultimediaControl**

The audio players and the movie players share the same control interface on the physical devices. The control interface does not care if the device is a video player or an audio player. Below is a driver that will demonstrate that any class that implements the MultimediaControl Interface would be able to be instantiated and use its methods used no matter if it was an audio or movie player.

**GUI Update:**

-   Demonstrate this functionality in your user interface. For example, you could use the code below and call testMultimedia in your initialize method or you could do something more elaborate in the GUI.

```
  public static void testMultimedia() {
```

```
    AudioPlayer newAudioProduct = new AudioPlayer("DP-X1A", "Onkyo",
```

```
        "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
```

```
    Screen newScreen = new Screen("720x480", 40, 22);
```

```
    MoviePlayer newMovieProduct = new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen,
```

```
        MonitorType.LCD);
```

```
    ArrayList<MultimediaControl> productList = new ArrayList<MultimediaControl>();
```

```
    productList.add(newAudioProduct);
```

```
    productList.add(newMovieProduct);
```

```
    for (MultimediaControl p : productList) {
```

```
      System.out.println(p);
```

```
      p.play();
```

```
      p.stop();
```

```
      p.next();
```

```
      p.previous();
```

```
    }
```

```
  }
```

**Week 9 Polymorphism**

**Issue 4 - ProductionRecord**

Create a ProductionRecord class with int fields for productionNumber (this will be unique for every item produced and get auto incremented by the database), an int field for productID (to correspond to the productID from the Product table / class), String field for serialNumber, and a field for the dateProduced that is type Date (from java.util).

Create accessors and mutator for all fields.

Make one constructor that just has a parameter for the productID. This will be the constructor called when the user records production from the user interface.

In this constructor,

-   Set the productionNumber to 0 (because the database will end up auto-incrementing).
-   Set the serialNumber to "0" for now.
-   Set the date to the current date using new Date().

Create an overloaded constructor to use when creating ProductionRecord objects from the database. This constructor needs parameters for all fields.

Override toString to return a string in the format "Prod. Num: 0 Product ID: 0 Serial Num: 0 Date: Mon Oct 14 10:29:48 UTC 2019"

Display the production record in the TextArea on the Production Log tab.

Security / FindBugs tip: [Defensive copying](http://www.google.com/url?q=http%3A%2F%2Fwww.javapractices.com%2Ftopic%2FTopicAction.do%3FId%3D15&sa=D&sntz=1&usg=AFQjCNFz5mwRPjotdMVuv8z0xfhycnM0Rg)

**Week 10 Encapsulation**

**Issue 5 - Production enhancement**

Add the ability for the program to generate a unique serial number for each produced product.

-   Overload the ProductionRecord constructor to accept a Product and an int which holds the count of the number of items of its type that have been created. (You can write the code to generate the count later.)
-   Set the serialNumber to start with the first three letters of the Manufacturer name, then the two letter ItemType code, then five digits (with leading 0s if necessary) that are unique and sequential for the item type. The entire Serial Number should be programmatically created and assigned.
-   Optional (for now) challenge: Show the product name instead of the product ID in the TextArea on the Production Log tab.

**Week 11 Lists and ArrayLists**

**Issue 6 - TableView**

Show all Products in the Product Line tab TableView. See [http://tutorials.jenkov.com/javafx/tableview.html](http://www.google.com/url?q=http%3A%2F%2Ftutorials.jenkov.com%2Fjavafx%2Ftableview.html&sa=D&sntz=1&usg=AFQjCNHlI4bvxrGb2-5iyo8fTrFug9QceQ) and [TableViewData sample program](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fprofvanselow%2FTableViewData&sa=D&sntz=1&usg=AFQjCNE-kK-F_6R2GWHSJXBM14C5JTyi_Q).

-   Create an ObservableList named _productLine_ to hold all of the Products that can be produced. For now, when the Add Product button is clicked, add to this list.
-   Set the items of the TableView to the ObservableList
    -   You can do this in a `setupProductLineTable` that also sets the columns and does the setCellValueFactory

Show all Products in the Produce tab ListView.

-   Use the selected item from the ListView as the item used to record production.

Show the production log in the Production Log tab TextArea.

<img src="https://iili.io/H5K3cg.png" alt="Package productiontracker" border="0">

<img src="https://iili.io/H5KfHJ.jpg" alt="h2" border="0">