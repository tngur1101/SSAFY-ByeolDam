import { Suspense, useEffect, useRef, useState } from 'react';
import { Canvas } from '@react-three/fiber';
import { FirstPersonControls, Stars } from '@react-three/drei';
import { Bloom, EffectComposer } from '@react-three/postprocessing';
import { useNavigate } from 'react-router-dom';

import { login } from '../../apis/member';
import ConstellationGenerator from '../../components/three/objects/ConstellationGenerator';

export default function Member() {
  const controller = useRef();
  const [email, setEmail] = useState();
  const [password, setPassword] = useState();
  const navigate = useNavigate();

  const userLogin = (event) => {
    event.preventDefault();
    login({ email, password })
      .then(() => {
        navigate('/home');
      })
      .catch((e) => {
        alert('아이디 또는 비밀번호가 일치하지 않거나 존재하지 않는 아이디입니다.');
      });
  };

  useEffect(() => {
    if (sessionStorage.token) navigate('/home');
  }, []);

  return (
    <div className="member-container">
      <div className="member-box">
        <div className="member-logo-box">
          <img src="/src/assets/images/temporary-logo.png" className="member-box-logo" alt="logo" />
        </div>
        <form className="member-login-box" onSubmit={userLogin}>
          <input
            className="member-input"
            type="email"
            onChange={(e) => {
              setEmail(e.target.value);
            }}
            placeholder="이메일을 입력해주세요"
          />
          <input
            className="member-input"
            type="password"
            onChange={(e) => {
              setPassword(e.target.value);
            }}
            placeholder="비밀번호를 입력해주세요"
          />
          <button className="member-button">로그인</button>
        </form>
        <div className="member-singup-button">계정이 없으신가요?</div>
        <div className="member-socials-box">
          <div className="member-separator-box">
            <div className="member-separator" />
            <p className="member-separator-text">또는</p>
            <div className="member-separator" />
          </div>
          <div className="social-logos">
            <img className="social-logo" src="/src/assets/images/socials/naver.png" alt="" />
            <img className="social-logo" src="/src/assets/images/socials/kakao.png" alt="" />
            <img className="social-logo" src="/src/assets/images/socials/google.png" alt="" />
          </div>
        </div>
      </div>
      <Canvas>
        <FirstPersonControls ref={controller} position={[0, 0, 0]} movementSpeed={0} />
        <Stars saturation={0.1} speed={0.7} fade />
        <Suspense fallback={null}>
          <ConstellationGenerator controllerRef={controller} />
        </Suspense>
      </Canvas>
    </div>
  );
}
