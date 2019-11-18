import { Component, OnInit } from '@angular/core';
import { PostsService } from '../../service/posts.service'
import { Posts } from 'src/app/shared/models/posts.model';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  private posts: Posts[] = [];

  constructor(private postService: PostsService) { }

  ngOnInit() {
    console.log('before');
    this.postService.getPosts().subscribe(posts => {
      console.log(posts);
      this.posts = posts;
    });
    console.log('after');
  }

}
