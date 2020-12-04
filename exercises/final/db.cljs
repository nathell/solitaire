(ns solitaire.db
  (:require [solitaire.board :as board]))

(def default-db
  {:status :not-started, :board board/initial-board})
