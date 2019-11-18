import {Post} from "./post.model";

export class Posts {
    public id: number;
    post: Post;

    public toString = () : string => {
        return `Post (${this.id} -- ${this.post.post})`;
    }
}