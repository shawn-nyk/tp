---
layout: page
title: User Guide
---

# InternHunter User Guide

---

## Table Of Contents

[1. Introduction](#introduction) <br />
 [1.1. What our app manages](#what-our-app-manages) <br />
[2. Quick start](#quick-start) <br />
[3. Features](#features) <br />
 [3.1. Company Profile](#company-profile) <br />
  [3.1.1. Adding a company profile: `add -com`](#adding-a-company-profile-add--com) <br />
  [3.1.2. Deleting a company profile: `delete -com`](#deleting-a-company-profile-delete--com) <br />
  [3.1.3. Editing a company profile: `edit -com`](#editing-a-company-profile-edit--com) <br />
  [3.1.4. Viewing a company profile: `view -com`](#viewing-a-company-profile-view--com) <br />
 [3.2. Internship Application](#internship-application) <br />
  [3.2.1. Adding an internship application: `add -int`](#adding-an-internship-application-add--int) <br />
  [3.2.2. Deleting an internship application: `delete -int`](#deleting-an-internship-application-delete--int) <br />
  [3.2.3. Editing an internship application: `edit -int`](#editing-an-internship-application-edit--int) <br />
  [3.2.4. Viewing an internship application: `view -int`](#viewing-an-internship-application-view--int) <br />
 [3.3. User Profile](#user-profile) <br />
  [3.3.1. Adding to user profile: `add -me`](#adding-to-user-profile-add--me) <br />
  [3.3.2. Deleting from user profile: `delete -me`](#deleting-from-user-profile-delete--me) <br />
  [3.3.3. Editing user profile: `edit -me`](#editing-user-profile-edit--me) <br />
  [3.3.4. Viewing item in user profile: `view -me`](#viewing-item-in-user-profile-view--me) <br />
 [3.4. Switching Tabs](#switching-tabs-switch) <br />
 [3.5. Viewing Help](#viewing-help-help) <br />
 [3.6. Exiting the program](#exiting-the-program-exit) <br />
[4. Command Summary](#command-summary) <br />

---

## Introduction

InternHunter is a CLI-centric desktop application which aids university students in applying for tech internships.
It tracks and leverages on key metrics and information to create an optimal internship hunting experience.

#### What our app manages

InternHunter allows the management of three data types:

Data type | Alias | Attributes
----------|-------|-----------
Company | com | company name, industry, job title
Internship | int | company name, job title, industry, requirements, period, wage, status
Profile | me | category, descriptors

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `InternHunter.jar` from here.

1. Copy the file to the folder you want to use as the _home folder_ for your AddressBook.

1. Double-click the file to start the app or run `java -jar InternHunter.jar` from the terminal.

1. The [Features](#features) available in the current version of InternHunter are listed below.

--------------------------------------------------------------------------------------------------------------------

## Features

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add -com n/COMPANY_NAME i/INDUSTRY... j/JOB_TITLE...`, `COMPANY_NAME`, `INDUSTRY` and `JOB_TITLE` are
   parameters which can be used as `add -com n/Garena i/Gaming j/Game developer`.

* Items in square brackets are optional.<br>
  e.g `add -int n/COMPANY_NAME j/JOB_TITLE [i/INDUSTRY] [p/PERIOD] [w/WAGE] [r/REQUIREMENT]...` can be used as <br/> `add -int n/Google j/Software Engineer i/Software
`.

* Items with `...`​ after them can be used multiple times including zero times.<br>
  e.g. `[r/REQUIREMENT]...` can be used as `r/Rust`, `r/React native r/JavaScript` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `i/INDUSTRY r/REQUIREMENT`, `r/REQUIREMENT i/INDUSTRY` is also acceptable.

* `INDEX` refers to the index of the item in the displayed list of items (follows one-based indexing). <br>


### Company

Note: You must be viewing the **Companies** page in order to execute these commands.

#### Adding a company: `add com`

Adds a company to your list of companies.

Format: `add com n/COMPANY_NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/INDUSTRY]...`

Examples:
- `add com n/Google p/65218000 e/GoogleHires@gmail.com a/70 Pasir Panjang Rd, #03-71 t/Cloud Computing t/Artificial Intelligence`
- `add com n/Garena a/201 Victoria St e/GarenaHires@gmail.com p/65093545`

#### Deleting a company: `delete com`

Deletes a company from your list of companies. All internships and applications associated with this company will also be deleted.

Format: `delete com INDEX`

Example:
- `delete com 5`

#### Editing a company: `edit com`

Edits a company in your list of companies.

Format: `edit com INDEX [n/COMPANY_NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/INDUSTRY]...`
- At least one of the optional fields must be provided.

Examples:
- `edit com 1 n/Google Singapore e/GoogleIsHiring@gmail.com`
- `edit com 2 p/61234567`

#### Viewing a company: `view com`

Selects a company in your list of companies to show in detail.

Format: `view com INDEX`

Example:
- `view com 3`

### Internship Application

#### Adding an internship application: `add -int`

Applies for an internship. This internship will be automatically added to the list of jobs in the company
(if company has already been created). Otherwise, it creates the company and adds this job into it.

Format: `add -int n/COMPANY_NAME j/JOB_TITLE [i/INDUSTRY] [p/PERIOD] [w/WAGE] [r/REQUIREMENT]...`

Examples:
- `add -int n/Google i/Software j/Software Engineer`
- `add -int n/Google i/Software j/Software Engineer r/React w/3000 r/HTML5`

**Already created the internship before?**

Fret not, we have an alternative method to apply for an internship! This format adds an internship with the company
name and job title only.

Format: `add -int n/COMPANY_NAME INDEX` - `INDEX` refers to position of internship in the company

:bulb: **Tip:** `view -com INDEX` (to view a company's profile, including its list of jobs)

#### Deleting an internship application: `delete -int`

Deletes an internship.
 
Format: `delete -int INDEX` 

Example:
- `delete -int 3`

#### Editing an internship application: `edit -int`

Edits an internship.

Format:  `edit -int INDEX [n/COMPANY_NAME] [j/JOB_TITLE] [i/INDUSTRY] [p/PERIOD] [w/WAGE] [s/STATUS] [d/DATE] 
[r/REQUIREMENT]...`

:information_source: **Note:** `DATE` can only be added if there is a `STATUS` in the input.

Examples:
- `edit -int 7 r/Java r/FXML w/2000`
- `edit -int 4 s/interview d/22-09-20`

**More about internships...**

Each job has its own status. On initial adding of internship, the status of the internship application is `Applied` by
default. Each status will be tagged to a date. If a date is not specified, InternHunter will assign today’s date to it.

Accepted statuses:
- `Applied`
- `Interview`
- `Waiting`
- `Rejected`
- `Offered`
- `Accepted`

Accepted date formats:

- d-M-yy HHmm
    - e.g. `23-12-19 2230`
- d-M-yy
    - e.g. `23-12-19`
    - Time will be taken as 2359

#### Viewing an internship application: `view -int`

Selects an internship application in the list of internship applications to show in detail.
 
Format: `view -int INDEX` - `INDEX` is the index of the internship application in the list of internship
applications

Example:
- `view -int 3`

### User Profile

#### Adding to user profile: `add -me`

Adds experience, skills or achievements descriptors to your user profile.

Format: `add -me c/CATEGORY d/DESCRIPTORS`

* Category specifies a category which can be either experience, skills or achievement.

Examples:
* `add -me c/achievement d/special recognition in Hack n Roll!`
* `add -me c/experience d/Internship at Govtech`
* `add -me c/skill d/HTML`

#### Deleting from user profile: `delete -me`

Deletes experience, skills and achievements descriptors from your user profile.

Format: `delete -me INDEX`

Example:
* `delete -me 2`

#### Editing user profile: `edit -me`

Edit the experience, skills or achievements descriptors of your user profile.

Format: `edit -me INDEX [c/CATEGORY] [d/DESCRIPTORS]`

* At least one of the optional fields must be provided.

Examples:
* `edit -me 2 c/skill d/CSS`
* `edit -me 4 c/achievement`

#### Viewing item in user profile: `view -me`

Selects an item in the user profile to show in detail.

Format: `view -me INDEX`

Example:
* `view -me 3`

### Switching Tabs: `switch`

Switches between tabs.

Format: `switch -TYPE`

There are three `TYPE`s:
* `com`
* `int`
* `me`

Example: 
* `switch -me`

### Viewing Help: `help`
Displays a link to the InternHunter user guide.

Format: `help`

### Exiting the Program: `exit`
Exits the program.

Format: `exit`

--------------------------------------------------------------------------------------------------------------------

## Command summary

Type            | Action     | Format
----------------|------------|------------------
**Company**     | **Add**    | `add -com n/COMPANY_NAME i/INDUSTRY... j/JOB_TITLE...`
&nbsp;          | **Delete** | `delete -com INDEX`
&nbsp;          | **Edit**   | `edit -com INDEX [n/COMPANY_NAME] [i/INDUSTRY]... [j/JOB_TITLE]...`
&nbsp;          | **View**   | `view -com INDEX`
**Internship**  | **Add**    | `add -int n/COMPANY_NAME j/JOB_TITLE [i/INDUSTRY] [p/PERIOD] [w/WAGE] [r/REQUIREMENT]...` <br/> `add -int n/COMPANY_NAME INDEX`
&nbsp;          | **Delete** | `delete -int INDEX`
&nbsp;          | **Edit**   | `edit -int INDEX [n/COMPANY_NAME] [j/JOB_TITLE] [i/INDUSTRY] [p/PERIOD] [w/WAGE] [s/STATUS] [d/DATE] [r/REQUIREMENT]...`
&nbsp;          | **View**   | `view -int INDEX`
**Profile**     | **Add**    | `add -me c/CAT d/DESCRIPTORS`
&nbsp;          | **Delete** | `delete -me INDEX`
&nbsp;          | **Edit**   | `edit -me INDEX [c/CAT] [d/DESCRIPTORS]`
&nbsp;          | **View**   | `view -me INDEX`
**General**     | **Switch** | `switch -TYPE`
&nbsp;          | **Help**   | `help`
&nbsp;          | **Exit**   | `exit`
