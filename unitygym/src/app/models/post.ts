import { Media } from "./media";

export interface Post {
  titre: string;
  contenu: string;
  media?: Media[];
}