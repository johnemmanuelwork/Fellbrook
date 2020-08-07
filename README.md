# Fellbrook

This is a fantasy choose your own adventure story that's currently a work in progress.

Already implemented:
- Overall layout using an MVP pattern.
- Story text changes with each choice.
- Buttons for choices are dynamically generated based on the number of options available.

Things to implement:
- Health system. It's currently just text.
- Complete the character menu and inventory menus to contain accurate stats and provide the option to use items.
- Combat system: new activity for resolving combat.
- Classes for the player, monsters and items.
- Toast notifications when damage is taken.
- Game over element: If the player makes a decision that causes their health to drop below 1, generate the game over variant of the page they're transitioning to instead of taking them to the original page and then displaying game over.
