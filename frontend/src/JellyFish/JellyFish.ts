import { useLottie } from "lottie-react";
import groovyWalkAnimation from "./jellyFish.json";
 
const JellyFish = () => {
  const options = {
    animationData: groovyWalkAnimation,
    loop: true,
    autoplay: true,
  };
 
  const { View } = useLottie(options);
 
  return View;
};
 
export default JellyFish;