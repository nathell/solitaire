(ns solitaire.fx
  (:require [re-frame.core :as rf]))

(rf/reg-fx
 :alert
 (fn [message]
   (js/alert message)))
