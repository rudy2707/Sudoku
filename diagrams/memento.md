
CareTaker -> Undo mechanism
---------
List of Originators with static memento with each states

Responsable de la bonne garde (safekeeping) du memento
Il ne va jamais voir ou modifier le contenu du memento

Le Caretaker va faire une requete a l'Originator pour avoir un memento, le garde le temps
qu'il en a besoin et le rend a l'Originator (parfois il le rend pas)
C'est le caretaker qui s'occupe de stocker les mementos

Memento -> SolverState
-------
Store a state, a state is a Sudoku object

Stock l'etat interne d'un object Originator.
Ne peut pas etre acceder par d'autres objets que l'Originator
Le Caretaker peut seulement passer une instance du memento a un autre objet
L'Originator, par contre, peut acceder au details du memento pour pouvoir le sauver et le restaurer
Seul l'Originator qui a cree le memento peut acceder a son etat interne (idealement)


Originator -> ConstraintSolver
----------
Allows to save the memento

C'est le seul qui peut sauver et restaurer des etats !
Il cree un memento contenant une copie de l'etat actuel
et utilise le memento pour restaurer l'etat

Consequences
------------

- Preservation de l'encapsulation

Le memento n'expose pas ces informations, seul l'Originator peut modifier

- Si on doit sauver beaucoup d'information, c'est lourd

- Un Caretaker peut supprimer un memento, mais il ne sait pas combien d'etat le memento contenait

Sudoku
------
Object with grid of the game
