import {Component, OnInit,Injectable} from 'angular2/core';

import {UserPo} from './po/UserPo';
import {ResultPo}    from '../common/resultPo.conponent';
import {UserService} from "./service/user.service";

@Component({
    selector: 'user-list',
    templateUrl:'app/sys/html/user.html',
})

@Injectable()
export class UserListComponent implements OnInit {
    constructor(
        private userService: UserService
    ){}
    title = 'Tour of Heroes';
    users : UserPo[];
    errorMessage: string;
    selectedUser: UserPo;
    updateIndex:number;

    ngOnInit() {
        this.getPos();
        console.log("this.users2:"+JSON.stringify(this.users));
    }

    getPos() {
        this.userService.getPos().subscribe(
            users=>this.users=users,
            error =>  this.errorMessage = <any>error);
    }

    createPo(){
        this.selectedUser = null;
    }

    updatePo(i:number,user:UserPo) {
        this.selectedUser = user;
        this.updateIndex=i;
    }

    deletePo(i:number, id:number){
        this.userService.deletePo(id).subscribe(
            resultPo=>resultPo.id=1,
            error =>  this.errorMessage = <any>error);
        this.users.splice(i,1);
    }
    data: string;

    onSubmit(data){
        if(data.id){
            this.userService.updatePo(data).subscribe(
                user => this.users[this.updateIndex] = user,
                error => this.errorMessage=<any>error
            );
        }else {
            this.userService.addPo(data).subscribe(
                user => this.users.push(user),
                error => this.errorMessage=<any>error
            );
        }
        //jQuery(function(){
        //    alert("jquery3");
        //});
        $('#myModal').modal('hide');
    }
    fileUpload(data){
        this.userService.fileUpload(data).subscribe(
            resultPo=>resultPo.id=1,
            error =>  this.errorMessage = <any>error);
    }
}