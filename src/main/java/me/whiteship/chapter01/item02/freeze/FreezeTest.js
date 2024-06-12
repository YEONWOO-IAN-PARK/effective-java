const keesun = {
    'name': 'Keesun',
    'age': 40
};

Object.freeze(keesun);  // 객체 Freezing 시점에서 해당 객체의 추가/삭제/수정이 모두 불가능하다.

keesun.kids = ["서연"];

console.info(keesun.name);

//////////////////////////////////////////////////////////////////////////////////////

