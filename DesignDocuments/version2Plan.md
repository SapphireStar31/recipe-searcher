# Recipe Searcher Version 2 Changes/Plans/Ideas
## User Stories that weren't completed
- As a user, I want to be able to see if a recipe follows certain dietary restrictions, so that I can find ones that fit my restrictions.
- As a logged-in user, I want to be able to add ingredients to other recipes, so that if there are ingredients I use and not others I can add them.
- As a user, I want to be able to report duplicate recipes, so that there aren't multiple of the same recipe I have to look through.
- As a college student, I want to be able to be able to go to a random recipe, so that even if I don't know any recipes I can find some random ones I might like.
- As an admin, I want to be able to get reports that users make, so that I can see where issues are and fix them.

One part of version two is finishing up these user stories. I wasn't able to add in the capability for other users to add in ingredients to an already existing recipe, but that would be one of the first things I'd want to add.

After that I would want to be able to add in users being able to make reports about issues. That way when issues pop up users can report and admins can look faster than admins always keeping an eye out.

Being able to find a random recipe would definitely be a nice addition, but isn't on top of the priority list. Finally dietary restrictions are going to take me learning about what kind of restrictions are out there so thats very low on the list, but it'd be neat to find an API that might figure that out for me.

## Changes
- In version 2 I would change up the CSS and styling. Add in some more accessibility features (since there isn't many currently) and a little more color. I'd also take a look at adding in a dark mode for those that like dark modes just like me.
- Another change would be looking deeper into adding links for the suggested recipes that Spoonacular finds. Spoonacular I believe has links to actual recipes with instructions on how to make their recipes, but you need to go through a couple different endpoints to get to it. Plus on the free version I only get a certain amount of points, so I'd want to make sure I don't go over that limit by trying to add those in or cause loading times to be very slow.
- Currently, when searching either recipes or ingredients it gives you a list of either ingredients in the recipe or recipes with the ingredient, but I'd like to change that to limit the amount of recipes or ingredients it shows. If the database gets larger, so do those lists so limiting them makes it so users don't have to scroll as far.
- Right now users cannot delete their own accounts, so that is another change allowing a user to delete their own account without needing admin intervention.

## Plans
- Another plan would be able to allow users to favorite recipes they find. I didn't have enough time to try adding it this time, but it'd be a great addition especially when more recipes are added and there is more to look through. I'd probably have to change my database design to have a table holding a user and their favorite recipes. Then add in some pages showing the user their favorite recipes.
- Adding in some more verification for inputs and custom error messages when something is wrong.

## Ideas
- An idea for the future might be adding in pictures for recipes. That way users can see what it looks like and other users can add a picture of their own.


