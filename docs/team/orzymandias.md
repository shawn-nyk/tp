---
layout: page
title: Gan Wan Cheng Isaac's Project Portfolio Page
---

## Project: InternHunter

InternHunter is a CLI-centric desktop application which aids university students in applying for tech internships.
It lets users manage their own customisable collection of companies, internships, internship applications and their 
own user profile, so that they can keep track of internships that they are interested in.

It has a GUI created with JavaFX. It is written in Java, and has about 35k LoC.

## Summary of contributions
    
  * Add Profile Items (Pull request [\#142](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/142))
    * What it is: Allows the user to add a profile item to the profile list 
    * Highlights: This enhancement affects other commands like the match command and commands to be added in future. It
     required an in-depth analysis of design alternatives. It allows users to keep track of profile item which stores
      an title, category which is an enum type and a set of descriptors complying with a fixed set of characters.
     AddProfileParser has to ensure that user input obey certain constraints before it can be added to the profile
      list. 
  * Delete a Profile Item (Pull request [\#150](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/150))
    * What it does: Allows the user to delete a profile item from the app's profile
  * Edit a Profile Item (Pull request [\#154](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/154))
    * What it does: Allows the user to edit a profile item.
  * View a Profile Item (Pull request [\#155](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/155))
    * What it does: Allows the user to view a profile item from the app's profile list in full detail.
  * Find profile items (Pull request [\#253](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/253))
    * What it does: Allows the user to find profile items by title from the profile list.
  * List all profiles(Pull request [\#253](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/253))
    * What it does: Allows the user to list all profile items.
  * Add internship (Pull request [\#151](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/151/))
    * What it is: Allows the user to add an internship to a company's internship list.
    * Highlights: Unlike the add profile command, the add internship command is a more challenging feature as it
     needs to account for the composition relationship between the company and internship objects. The
      addInternshipCommand has retrieve the company targeted, check for duplicates in a company's internship list
      
  * Parser and Command Structure Design (Pull request [\#118](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/118)
    * What it is: Allows one command word to be used for multiple entity types.
    * Highlights: Instead of the need to implement a long switch statement for all the command words (where more than
     20 commands words will need to be specified for every operation of each entity type), the parser is designed such
     that a single command word can be used to specify the operation for multiple entity types. Similar commands
     classes for different entities all extend the same abstract class so that the the operation's CommandParser can
     leverage on polymorphism to return the command for execution. This is a useful design as it can be
     applied to all the other kinds of entities which share common operations.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=orzymandias&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

* **Documentation**:
  * User Guide:
    * Added documentation for profile features - add, delete, edit, view, list, find.
    (Pull requests [\#82](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/82), 
    [\#260](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/260), [\#271](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/271))
    * Update overview portion and contents page.
  * Developer Guide:
    * Added implementation details and UML diagrams for the 'Edit a profile item' feature. 
    (Pull request [\#216](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/216))
    * Added  details and UML diagrams for the 'Architecture'. (Pull request [\#288](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/288))
    * Added use cases for all profile items, find, list, help and exit commands. (Pull requests [\#92](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/92
    ), [\#124](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/124), [\#256](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/256))
    * Added Non Functional Requirements (Pull requests [\#92](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/92))
    * Added Effort Section (Pull request [\#363](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/363))
    * Refactoring of Developer guide. (Pull request [\#256](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/256))
    
* **Team-based tasks**:
  * Maintaining the issue tracker.
  * Integration code for common functions.
  * Documenting team effort.

* **Enhancements to existing features**:

* **Community**:
  * PRs reviewed (with non-trivial review comments): 
  [\#98](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/98), 
  [\#141](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/141), 
  [\#258](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/258), 
  [\#140](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/140)
  
  * All other PRs reviewed: 
  [\#79](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/79),
  [\#80](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/80),
  [\#86](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/86),
  [\#87](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/87),
  [\#95](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/95),
  [\#100](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/100),
  [\#104](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/104),
  [\#122](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/122),
  [\#146](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/146),
  [\#164](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/164),
  [\#167](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/167),
  [\#179](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/179),
  [\#190](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/190),
  [\#197](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/197),
  [\#205](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/205),
  [\#217](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/217),
  [\#218](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/218),
  [\#285](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/285),
  [\#291](https://github.com/AY2021S1-CS2103T-T15-4/tp/pull/291)
  
  * Reported bugs and suggestions for other teams in the class. Bug reports:
  [1](https://github.com/AY2021S1-CS2103T-W11-4/tp/issues/199), 
  [2](https://github.com/AY2021S1-CS2103T-W11-4/tp/issues/198), 
  [3](https://github.com/AY2021S1-CS2103T-W11-4/tp/issues/197), 
  [4](https://github.com/AY2021S1-CS2103T-W11-4/tp/issues/196), 
  [5](https://github.com/AY2021S1-CS2103T-W11-4/tp/issues/195), 
  [6](https://github.com/AY2021S1-CS2103T-W11-4/tp/issues/194), 
  [7](https://github.com/AY2021S1-CS2103T-W11-4/tp/issues/193), 
  [8](https://github.com/AY2021S1-CS2103T-W11-4/tp/issues/192), 
  [9](https://github.com/AY2021S1-CS2103T-W11-4/tp/issues/191), 
  [10](https://github.com/AY2021S1-CS2103T-W11-4/tp/issues/190), 
  [11](https://github.com/AY2021S1-CS2103T-W11-4/tp/issues/189), 
  [12](https://github.com/AY2021S1-CS2103T-W11-4/tp/issues/188), 
  [13](https://github.com/AY2021S1-CS2103T-W11-4/tp/issues/187), 
  [14](https://github.com/AY2021S1-CS2103T-W11-4/tp/issues/186), 
  [15](https://github.com/AY2021S1-CS2103T-W11-4/tp/issues/185)
  
* **Tools**:
  * Integrated a new Github plugin (CircleCI) to the team repo

* _{you can add/remove categories in the list above}_

## Contributions to the User Guide

## Contributions to the Developer Guide
