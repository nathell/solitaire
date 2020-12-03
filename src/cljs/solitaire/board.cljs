(ns solitaire.board)

;;; Layout

(def initial-layout
  '[[. . o o o . .]
    [. . o o o . .]
    [o o o o o o o]
    [o o o _ o o o]
    [o o o o o o o]
    [. . o o o . .]
    [. . o o o . .]])

(defn layout->board [board]
  (mapv (partial mapv {'. :blocked, 'o :peg, '_ :empty}) board))

(def initial-board (layout->board initial-layout))

;;; Accessing the board

(defn dimensions [board]
  [(count (first board)) (count board)])

(defn coord-seq [board]
  (let [[width height] (dimensions board)]
    (for [y (range height) x (range width)]
      [x y])))

(defn field-at [board [x y]]
  (get-in board [y x]))

(defn update-field [board [x y] item]
  (assoc-in board [y x] item))

(defn count-pegs [board]
  (count (filter #{:peg} (flatten board))))

;;; Game rules

(defn midpoint [[x y] [x' y']]
  (cond
    (and (= x' x) (= y' (- y 2))) [x (- y 1)]
    (and (= x' x) (= y' (+ y 2))) [x (+ y 1)]
    (and (= x' (- x 2)) (= y' y)) [(- x 1) y]
    (and (= x' (+ x 2)) (= y' y)) [(+ x 1) y]
    :otherwise                    nil))

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

(defn potential-targets [[x y]]
  [[x (- y 2)]
   [x (+ y 2)]
   [(- x 2) y]
   [(+ x 2) y]])

(defn can-move-anywhere? [board source]
  (some (partial can-move? board source)
        (potential-targets source)))

(defn game-over? [board]
  (not (some (partial can-move-anywhere? board)
             (coord-seq board))))
