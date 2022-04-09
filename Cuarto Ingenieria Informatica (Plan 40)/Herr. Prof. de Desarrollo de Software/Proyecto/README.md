# H.P.D.S. FINAL ASSIGNMENT

## Tags used for commit messages

* -master- [message] : Commit made strictly from master branch
* -dev- [message] : Commit made from any develop branch
* -release- [message] : Commit made for releasing process
* -version- [message] : Commit made when a new tag is created
* -hotfix- [message] : Commit made from hot-fix branch
* -tag- [message] : Commit made only to add new version tags

## Main assets of IFTTT
* Sensor: Takes data from the environment and sends it to the account.
* Account: Links both Sensors and Actuators. 
* Actuator: Performs a procedure once th specified conditions have met.
* Rule: Stablishes a set of conditions to be fullfiled
* Condition: Sets an status to be accomplished

# Rules defined:

# Rules:

## Basic
* B1. If pressure sensor has been triggered, the desk must be cleaned. LED goes to YELLOW_STATUS, and switch to yellow color.
* B2. If QR_USE has been sent for the first time, the desk goes to QR_SENT.
* B3. If QR_USE has been sent more than once, desk status keeps in QR_SENT.
* B4. If pressure sensor has been off for more than 15mins, the desk must be cleaned. LED goes to YELLOW_STATUS, and switch to yellow color.
* B5. If desk QR_CLEAN has been sent, desk goes to GREEN_STATUS. LED turns to green.
* B6. If QR_LEAVE has been sent for the first time, the desk must be cleaned. goes to LED goes to YELLOW_STATUS, and switch to yellow color.
* B7. If LED is in BLUE_STATUS and the weight sensor is triggered in less than 15 minutes, LED goes to RED_STATUS. The desk is currently in use.

## Complex 
* C1. If rules B1. and B2. goes to UP, LED goes to RED_STATUS. The desk is currently in use.
* C2. If desk is currently in ON_USE status and pressure sensor detects no weight, LED goes to BLUE_STATUS. The desk is in use but not currently occupied.
