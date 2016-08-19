# Vaadin Expo booth example application

This is a starting point for showing how Vaadin Designer works. Part 2 of the JavaOne booth pitch.

## Before JavaOne

Clone this repository for yourself 
```
git clone git@gitlab.vaadin.com:fredu/vaadin-designer-javaone.git
mvn install
```
Import the javaone-ui project (only) to your IDE.

## The Booth Pitch

Command prompt before starting: 
```
git reset --hard before next
```

Start the server and show the project.
```
Debug as -> Maven build... -> Jetty:run
```

> This is the standard example archetype for Vaadin Framework. 

Click around and show the form by selecting something in the grid.

> Let's change the form a bit. The buttons could be made prettier and there are some things in the grid we want to edit as well.

Open the design file in designer.

> Drag 2 textfields and wrap them in a horisontal layout

Name the Textfields price and stockCount and add a label.

Show the Wrap function in Designer.

> Let's also make it nicer in a UX sense.

Click expand-arrow in layout + 2 textfields.

Add spacing for the horisontal layout (checkbox).

> Let's also change the styling of the buttons.

Save: primary
Delete: danger

Show the design on mobile.
Show the entire app on mobile (change the port to 8080).

> One more thing. There are tons of add-ons in Vaadin, 600 in fact, and they're very easy to take into use. Let's look at the Spreadsheet component

Open the StatsView class

Check out the Stats view and comment out the code. Show how the Stats.xlsx content is now in a spreadsheet and editable. 
