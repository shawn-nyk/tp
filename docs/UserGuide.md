---
layout: page
title: User Guide
---

# InternHunter User Guide

---

## Table Of Contents

[1. Introduction](#introduction) <br />
[2. Quick start](#quick-start) <br />
[3. Features](#features) <br />
&nbsp;&nbsp;&nbsp;&nbsp;[3.1. Company Profile](#company-profile) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.1.1. Adding a company profile: `add -com`](#Adding-a-company-profile) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.1.2. Deleting a company profile: `delete -com`](#Deleting-a-company-profile) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.1.3. Editing a company profile: `edit -com`](#Editing-a-company-profile) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.1.4. Viewing a company profile: `view -com`](#Viewing-a-company-profile) <br />
&nbsp;&nbsp;&nbsp;&nbsp;[3.2. Internship Application](#internship-application) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.2.1. Adding an internship application: `add -int`](#Adding-an-internship-application) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.2.2. Deleting an internship application: `delete -int`](#Deleting-an-internship-application) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.2.3. Editing an internship application: `edit -int`](#Editing-an-internship-application) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.2.4. Viewing an internship application: `view -int`](#Viewing-an-internship-application) <br />
&nbsp;&nbsp;&nbsp;&nbsp;[3.3. User Profile](#user-profile) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.1. Adding skills and achievement: `add -me`](#Adding-skills-and-achievement) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.2. Deleting skills and achievement: `delete -me`](#Deleting-skills-and-achievement) <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[3.3.3. Editing skills and achievement: `view -me`](#Editing-skills-and-achievement) <br />
&nbsp;&nbsp;&nbsp;&nbsp;[3.4. Switching Tabs](#switching-tabs) <br />
&nbsp;&nbsp;&nbsp;&nbsp;[3.5. Viewing Help](#viewing-help) <br />
&nbsp;&nbsp;&nbsp;&nbsp;[3.6. Exiting the program](#exiting-the-program) <br />
[4. Command Summary](#command-summary) <br />

---

## Introduction

InternHunter is a CLI-centric desktop application which aids university students in applying for tech internships. It tracks and leverages on key metrics and information to create an optimal internship hunting experience.

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `InternHunter.jar` from here.

1. Copy the file to the folder you want to use as the _home folder_ for your AddressBook.

1. Double-click the file to start the app or run `java -jar InternHunter.jar` from the terminal. The features available in the current version of InternHunter are listed below: 

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add -com n/COMPANY_NAME i/INDUSTRY j/JOBS`, `COMPANY_NAME, INDUSTRY, JOBS` are parameters which can be used as `add -com n/Garena i/Gaming j/Game developer`.

* Items in square brackets are optional.<br>
  e.g `add -int n/COMPANY_NAME j/JOB_NAME  [i/INDUSTRY] [p/PERIOD] [w/WAGE] [r/REQUIREMENT]...` can be used as <br/> `add -int n/Google j/Software Engineer i/Software
`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[r/REQUIREMENT]...​` can be used as `r/Rust`, `r/React native r/JavaScript` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `i/INDUSTRY r/REQUIREMENT`, `r/REQUIREMENT i/INDUSTRY` is also acceptable.

</div>

#### Overview
Data type | Alias | Attributes
----------|-------|-----------
Company | com | company name, industry, jobs
Internship | int | company name, job name, industry, requirements, period , wage, status
Profile | me | type, descriptors


