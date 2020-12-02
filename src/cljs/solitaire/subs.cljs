(ns solitaire.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::board
 (fn [db _]
   (:board db)))
