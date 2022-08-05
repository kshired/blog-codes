const express = require('express');
const { editProfile } = require('./profile');
const authJwt = require('./authJWT');
const refresh = require('./refresh');

const router = express.Router();

/* 
 * user 프로필을 변경하려면 권한이 필요하기 때문에 authJWT 미들웨어를 적용합니다.
 * 이제 이 router는 access token을 헤더에 담아서 요청해야합니다. 
 */
router.get('/profile', authJWT, editProfile);
router.get('/refresh', refresh);

module.exports = router;