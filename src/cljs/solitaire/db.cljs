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

(defn midpoint [[x y] [x' y']]
  (cond
    (and (= x' x) (= y' (- y 2))) [x (- y 1)]
    (and (= x' x) (= y' (+ y 2))) [x (+ y 1)]
    (and (= x' (- x 2)) (= y' y)) [(- x 1) y]
    (and (= x' (+ x 2)) (= y' y)) [(+ x 1) y]
    :otherwise                    nil))

(defn field-at [board [x y]]
  (get-in board [y x]))

(defn update-field [board [x y] item]
  (assoc-in board [y x] item))

(defn can-move? [board source target]
  (and (= (field-at board source) :peg)
       (= (field-at board target) :empty)
       (when-let [mid (midpoint source target)]
         (= (field-at board mid) :peg))))

(defn move [board source target]
  (let [mid (midpoint source target)]
    (-> board
        (update-field source :empty)
        (update-field mid :empty)
        (update-field target :peg))))
