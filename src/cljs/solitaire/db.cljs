(ns solitaire.db)

(def initial-board
  '[[. . o o o . .]
    [. . o o o . .]
    [o o o o o o o]
    [o o o _ o o o]
    [o o o o o o o]
    [. . o o o . .]
    [. . o o o . .]])

(defn parse-board [board]
  (mapv (partial mapv {'. :blocked, 'o :peg, '_ :empty}) board))

(def default-db
  {:state :not-started, :board (parse-board initial-board)})
