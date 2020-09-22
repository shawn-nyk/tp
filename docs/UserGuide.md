---
layout: page
title: User Guide
---

## Features

### User Profile

#### Adding to user profile: `add -me`

Adds experience, skills or achievements descriptors to your user profile.

Format: `add -me  c/CATEGORY d/DESCRIPTORS`

* Category specifies a category which can be either experience, skills or achievement.

Examples:
* `add -me c/achievement d/special recognition in Hack n Roll!`
* `add -me c/experience d/Internship at Govtech`
* `add -me c/skill d/HTML`

#### Deleting to user profile: `delete -me`

Deletes experience, skills and achievements descriptors from your user profile.

Format: `delete -me INDEX`

* INDEX refers to the index of the item in the displayed list of items.
* INDEX follows a one based indexing.

Example:
* `delete -me 2`

#### Editing user profile: `edit -me`

Edit the experience, skills or achievements descriptors of your user profile.

Format: `edit -me INDEX [c/CATEGORY] [d/DESCRIPTORS] `

* At least one of the optional fields must be provided.
* INDEX refers to the index of the item in the displayed list of items.
* INDEX follows a one based indexing.

Example:
* `edit -me 2 c/skill d/CSS`
* `edit -me 4 c/achievement`

#### Viewing an item in user profile: `view -me`

Selects an item in the user profile to show in detail.

Format: `view -me INDEX`

* INDEX refers to the index of the item in the displayed list of items.
* INDEX follows a one based indexing.

Example:
* `view -me 3`
