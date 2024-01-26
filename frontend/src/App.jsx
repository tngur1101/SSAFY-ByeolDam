import { Route } from 'wouter';

import Member from './pages/member/Member';
import Universe from './pages/Universe';

import './assets/styles/main.scss';

export default function App() {
  return (
    <div className="App">
      <Route path="/" component={Member} />
      <Route path="/home" component={Universe} />
    </div>
  );
}
