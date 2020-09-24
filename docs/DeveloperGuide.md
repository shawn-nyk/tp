---
layout: page
title: Developer Guide
---
* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Appendix C: Use Cases

(For all use cases below, the **System** is `InternHunter` and the **Actor** is the `user`)

### Use case: UC01 - Add a company profile

#### MSS

Guarantees: Addition of company profile is successful

1. User requests to add a company profile and provides company details. 
2. InternHunter adds the company profile.<br/>
Use case ends.

#### Extensions

1a. InternHunter detects an error in the input format. <br/>
  1a1. InternHunter displays an error message and informs the user of the valid input format. <br/>
  Use case resumes from step 1.
    		
### Use case: UC02 - Delete a company profile

#### MSS

Precondition: User already has an existing list of company profiles <br/>
Guarantees: Deletion of company profile is successful

1. User requests to delete a company profile.
2. InternHunter removes the company profile from the list.<br/>
Use case ends.
    
#### Extensions

1a. InternHunter detects an error in the input format. <br/>
  1a1. InternHunter displays an error message and informs the user of the valid input format. <br/>
  Use case resumes from step 1.


### Use case: UC03 - View a company profile

##### MSS

Precondition: User already has an existing list of company profiles <br/>
Guarantees: Viewing of company profile is successful

1. User requests to view a company profile.
2. InternHunter displays the company profile.<br/>
Use case ends.

####  Extensions

1a. InternHunter detects an error in the input format. <br/>
  1a1. InternHunter displays an error message and informs the user of the valid input format. <br/>
  Use case resumes from step 1.

### Use case: UC04 - Edit a company profile

##### MSS

Precondition: User already has an existing list of company profiles <br/>
Guarantees: Editing of company profile is successful

1. User requests to edit the details of a company profile
2. InternHunter edits the details of this internship application. <br/>
Use case ends.

####  Extensions

1a. InternHunter detects an error in the input format. <br/>
  1a1. InternHunter displays an error message and informs the user of the valid input format. <br/>
  Use case resumes from step 1.

### Use case: UC05 - Add an internship application

#### MSS

Guarantees: Internship application is successful

1.  User requests to add an internship application and provides the relevant details.
2.  InternHunter adds the internship application to the list of internship applications.
3.  Internship application shows up in the bottom of the list. </br>
    Use case ends.

#### Extensions

1a. InternHunter detects an error in the input format. </br>
  1a1. InternHunter displays an error message and informs the user of the valid input format. </br>
  Use case resumes from step 1.


### Use case: UC06 - Delete an internship application

#### MSS

Precondition: User already has an existing list of internship applications </br>
Guarantees: Deletion of internship application is successful

1.  User requests to delete an internship application and provides the index.
2.  InternHunter removes the internship application from the list of internship applications and displays the new list. </br>
    Use case ends.

#### Extensions

1a. InternHunter detects that the index entered is out of bounds. </br>
  1a1. InternHunter displays an error message and informs the user of the valid input format. </br>
  Use case resumes from step 1.


### Use case: UC07 - View an internship application

#### MSS

Precondition: User already has an existing list of internship applications </br>
Guarantees: Viewing of internship application is successful

1.  User requests to view the details of an internship application.
2.  InternHunter shows the details of this internship application. </br>
    Use case ends.

#### Extensions

1a. InternHunter detects that the index entered is out of bounds. </br>
  1a1. InternHunter displays an error message and informs the user of the valid input format. </br>
  Use case resumes from step 1.
  
  
### Use case: UC08 - Edit an internship application

#### MSS

Precondition: User already has an existing list of internship applications </br>
Guarantees: Editing of internship application is successful

1.  User requests to edit the details of an internship application and inputs the index and details.
2.  InternHunter edits the details of this internship application and the list is updated accordingly. </br>
    Use case ends.

#### Extensions

1a. InternHunter detects that the index entered is out of bounds. </br>
  1a1. InternHunter displays an error message and informs the user of the valid input format. </br>
  Use case resumes from step 1.
  
1b. InternHunter detects an error in the input format. </br>
  1b1. InternHunter displays an error message and informs the user of the valid input format. </br>
  Use case resumes from step 1.


## Appendix E: Glossary

* **OS**: Operating System
* **Mainstream OS**: Windows, Linux, Unix, OS-X

--------------------------------------------------------------------------------------------------------------------
