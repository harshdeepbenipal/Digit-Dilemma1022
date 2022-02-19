Team Name: Code Chasers

Team Members:

- Harsh-Deep Benipal, hrsh9133@my.yorku.ca, Section N Lab 02
- Vincent Tran, vince03@my.yorku.ca, Section N Lab 02
- Gurtaj Dhindsa, dhindsag@my.yorku.ca, Section N Lab 01
- Khalia Brown, khaliab@my.yorku.ca, Section N Lab 02

Project: What number between 1 and X am I thinking of, using as few guesses as possible. 

App Name: Digit Dilemma

Description:

The user is prompted to input their name along with a difficulty level (easy, medium, or hard). The app chooses a random number based on the chosen level. If the user guesses correctly, they are notified and their score is the number of guesses it took. The app will keep a record of the highscore that the user has guessed correctly. Along with the app telling the user if they guess correctly, it will add their score to a scoreboard that contains other users' lowest amount of guesses. This scoreboard will consist of 10 scores. Each score will contain their name, score and date they acquired their score. The score will consist of the lowest guesses a user needed at the very top and so on. The app will alert the user of their score and congratulate them if their score is in the top 3 current scores.

Functional Requirements:

- Language being used is Java (application: android studio)
- The home screen displays the app name with a play button
- A “Home” button and a “?” (help button) will be displayed in the footer for all screens
- Upon clicking the play button the app will prompt the user to input their name and choose a difficulty level
- The difficulty levels will be displayed as 3 buttons from easy - 1 to 20, medium - 1 to 50 and hard 1 to 100 
- The app will decide a new number between 1 and X ( X given the range chosen from the difficulty level) and choose a number using random between this range for the user to attempt 
- The app will display how many attempts the user has done so far in the top right corner 
- If the user guesses incorrectly, the generated number will remain the same while the app will add 1 guess to their score and prompt the user to guess again
- If the user inputs a value that isn’t between 1 and X the app will alert the user and allow them to input again, (this guess won't be considered for the guess counter)
- The generated number will be displayed after the user forfeits or guesses correctly 
- If the user guesses correctly they will be given the option to play again 
- If the player chooses to play again, their previous score on the scoreboard will be replaced as long as the attempts taken were less than their previous 
- The score will then be added to the corresponding difficulty scoreboard if the score is lower than the rest or any that are present, along with their name and date the score was acquired. 
- If the name of the user is already present on the scoreboard their previous score will be replaced if the new score is lower
- The user will be alerted of their score and, if their name is already on the scoreboard, will be notified if their high score increased (user will be congratulated if in the top 3 for the scoreboard)
- The scoreboard will be based on which mode of difficulty the user chose and the order will be least guesses used, least to most
- There will be 3 scoreboards one for each difficulty level
- Each scoreboard will display the top 10 scores of that particular difficulty level.
- The user can view the scoreboard by clicking a button that is present in the footer
- The user can then choose the type of scoreboard they want to view by clicking on easy, medium or hard.

GOOGLE DRIVE LINK:
https://drive.google.com/drive/folders/1rIJ34ivV6iK1RwYx-wehO_C48cws83mG?usp=sharing
