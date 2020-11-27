import { useLottie } from "lottie-react";
import import_jellyFish_happy from "./jellyFish_happy.json";
import import_jellyFish_neutral from "./jellyFish_neutral.json";
import import_jellyFish_angry from "./jellyFish_angry.json";


 
export const JellyFish_happy = () => {
  const options = {
    animationData: import_jellyFish_happy,
    loop: true,
    autoplay: true,
  };
 
  const { View } = useLottie(options);
 
  return View;
};

export const JellyFish_neutral = () => {
  const options = {
    animationData: import_jellyFish_neutral,
    loop: true,
    autoplay: true,
  };
 
  const { View } = useLottie(options);
 
  return View;
};

export const JellyFish_angry = () => {
  const options = {
    animationData: import_jellyFish_angry,
    loop: true,
    autoplay: true,
  };
 
  const { View } = useLottie(options);
 
  return View;
};
