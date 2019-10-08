import React from 'react';
import { Admin, Resource } from 'react-admin';
import { PostList, PostEdit, PostCreate } from './posts';
import { UserList } from './users';
//注意这种写法
import Dashboard from './Dashboard';
import authProvider from './authProvider';

import jsonServerProvider from 'ra-data-json-server';
import PostIcon from '@material-ui/icons/LibraryBooks';
import UserIcon from '@material-ui/icons/Group';

import Menu from './Menu.js'

import myDataProvider from './myDataProvider';


const dataProvider = jsonServerProvider('http://jsonplaceholder.typicode.com');

const App = () => (
      <Admin menu={Menu} dashboard={Dashboard} authProvider={authProvider} dataProvider={dataProvider}>
         <Resource name="posts" list={PostList} edit={PostEdit} create={PostCreate} icon={PostIcon}/>
         <Resource name="users" list={UserList} icon={UserIcon}/>
      </Admin>
);

export default App;