---
layout: page
title: Developer Guide
---
* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Appendix C: Use Cases

(For all use cases below, the **System** is `InternHunter` and the **Actor** is the `user`)

### Use case: UC05 - Add an internship application

#### MSS

Guarantees: Internship application is successful

1.  User requests to add an internship application and provides the relevant details.
2.  InternHunter adds the internship application to the list of internship applications.
3.  Internship application shows up in the bottom of the list. <br />
    Use case ends.

#### Extensions

1a. InternHunter detects an error in the input format. <br />
  1a1. InternHunter displays an error message and informs the user of the valid input format. <br />
  Use case resumes from step 1.


### Use case: UC06 - Delete an internship application

#### MSS

Precondition: User already has an existing list of internship applications <br />
Guarantees: Deletion of internship application is successful

1.  User requests to delete an internship application and provides the index.
2.  InternHunter removes the internship application from the list of internship applications and displays the new list. <br />
    Use case ends.

#### Extensions

1a. InternHunter detects that the index entered is out of bounds. <br />
  1a1. InternHunter displays an error message and informs the user of the valid input format. <br />
  Use case resumes from step 1.

1b. InternHunter detects an error in the input format. <br />
  1b1. InternHunter displays an error message and informs the user of the valid input format. <br />
  Use case resumes from step 1.

### Use case: UC07 - View an internship application

#### MSS

Precondition: User already has an existing list of internship applications <br />
Guarantees: Viewing of internship application is successful

1.  User requests to view the details of an internship application.
2.  InternHunter shows the details of this internship application. <br />
    Use case ends.

#### Extensions

1a. InternHunter detects that the index entered is out of bounds. <br />
  1a1. InternHunter displays an error message and informs the user of the valid input format. <br />
  Use case resumes from step 1.
  
1b. InternHunter detects an error in the input format. <br />
  1b1. InternHunter displays an error message and informs the user of the valid input format. <br />
  Use case resumes from step 1.

### Use case: UC08 - Edit an internship application

#### MSS

Precondition: User already has an existing list of internship applications <br />
Guarantees: Editing of internship application is successful

1.  User requests to edit the details of an internship application and inputs the index and details.
2.  InternHunter edits the details of this internship application and the list is updated accordingly. <br />
    Use case ends.

#### Extensions

1a. InternHunter detects that the index entered is out of bounds. <br />
  1a1. InternHunter displays an error message and informs the user of the valid input format. <br />
  Use case resumes from step 1.
  
1b. InternHunter detects an error in the input format. <br />
  1b1. InternHunter displays an error message and informs the user of the valid input format. <br />
  Use case resumes from step 1.

### Use case: UC10 - Delete a user profile item 

#### MSS

Precondition: User already has an existing user profile items </br>
Guarantees: Deletion of user profile item is successful

1.  User requests to delete a user profile item from the user profile and provides the index.
2.  InternHunter removes the user profile item from the user profile. </br>
    Use case ends.

#### Extensions

1a. InternHunter detects an invalid input. </br>
  1a1. InternHunter displays an error message and informs the user of the valid input format. </br>
  Use case resumes from step 1.

### Use case: UC11 - Edit a user profile item

#### MSS

Precondition: User already has an existing list of user profile items </br>
Guarantees: Editing of user profile item is successful

1.  User requests to edit the details of a user profile item and inputs the index and details.
2.  InternHunter edits the user profile item from the user profile. </br>
    Use case ends.

#### Extensions
1a. InternHunter detects an invalid input. </br>
  1a1. InternHunter displays an error message and informs the user of the valid input format. </br>
  Use case resumes from step 1.


### Use case: UC12 - View a user profile item

#### MSS

Precondition: User already has an existing list of user profile items </br>
Guarantees: Viewing of user profile item is successful

1.  User requests to view the details of a user profile item.
2.  InternHunter shows the details of this internship application. </br>
    Use case ends.
    
#### Extensions
1a. InternHunter detects an invalid input. </br>
  1a1. InternHunter displays an error message and informs the user of the valid input format. </br>
  Use case resumes from step 1.

### Use case: UC13 - Switch tabs

#### MSS

1.  User requests to switch the tab of the screen.
2.  InternHunter switch to the requested tab. </br>
    Use case ends.

#### Extensions
1a. InternHunter detects an invalid input. </br>
  1a1. InternHunter displays an error message and informs the user of the valid input format. </br>
  Use case resumes from step 1.


### Use case: UC14 - Get help

#### MSS

Guarantees: User will get directions to the user guide

MSS:
1.  User requests for help.
2.  InternHunter displays help message directing user to user guide. </br>
    Use case ends.


### Use case: UC15 - Exit 

#### MSS

1.  User requests to exit InternHunter.
2.  InternHunter prompts for confirmation.
3.  User confirms intention to exit.
4.  InternHunter exits. </br>
    Use case ends.

#### Extensions
2a. User chooses to cancel the confirmation. </br>
    Use case ends.
    
## Appendix D: Non-Functional Requirements

* Should be for a single user i.e. (not a multi-user product).
* The data should be stored locally and should be in a human editable text file.
* The software should work without requiring an installer.
* Should work on any mainstream OS as long as it has Java 11 or above installed.
* Should work on both 32-bit and 64-bit environment.
* Should only use third-party frameworks or libraries which are free, open-source and have permissive license term and 
do not require installation by user of the software.
* A user with above average typing speed for regular English text should be able to accomplish most of the tasks faster 
using commands than using the mouse.
* Should be a result of evolving and morphing the given code base.
* Should be developed in a breadth-first incremental manner over the project duration.

## Appendix E: Glossary

* **OS**: Operating System
* **Mainstream OS**: Windows, Linux, Unix, OS-X

--------------------------------------------------------------------------------------------------------------------
