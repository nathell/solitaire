(ns solitaire.db
  (:require [solitaire.board :as board]))

(def default-db
  {:board board/initial-board, :selected-field [3 1]})
