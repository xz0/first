import {Component, OnInit} from 'angular2/core';
import {HTTP_PROVIDERS}    from 'angular2/http';

import {UserPo} from './sys/po/UserPo';
import {UserService} from "./sys/service/user.service";
import {UserListComponent} from "./sys/user-list.component";

@Component({
    selector: 'my-app',
    template: `
    <h1>hello </h1>
    <user-list></user-list>
    `,
    directives:[UserListComponent],
    providers: [
        HTTP_PROVIDERS,
        UserService,
    ]
})
export class AppComponent{
}