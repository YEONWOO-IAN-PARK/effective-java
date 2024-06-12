## 완벽 공략 7. 객체 얼리기 (freezing)
### 임의의 객체를 불변 객체로 만들어주는 기능

- Object.freeze(obj)에 전달한 객체는 그뒤로 변경될 수 없다.
  - 새 프로퍼티를 추가하지 못함
  - 기존 프로퍼티를 제거하지 못함
  - 기존 프로퍼티 값을 변경하지 못함
  - 프로토 타입을 변경하지 못함
- Strict 모드에서만 동작함
- 비슷한 류의 펑션으로 Object.seal(obj)과 Object.preventExtensions(obj)가 있다.
- 객체 동결 여부를 Object.isFrozen(obj)로 알 수 있다.

```javascript
const obj = {
	prop : 42
};

Object.freeze(obj);

obj.pop = 33;

console.log(obj.prop);
```

  
- Object.seal()
  - 객체를 밀봉한다.
  - 객체에 새로운 속성을 추가할 수 없다.
  - 기존에 존재하던 모든 속성을 설정 불가능한 상태로 만든다.
  - 하지만 쓰기 가능한 속성의 값은 밀봉 후에도 변경할 수 있다. (이 부분이 Object.freeze()와 차이점이다.)
  - 요약하면 속성 추가/삭제 불가능. 기존 속성값 변경 가능.
  - 객체 봉인 여부를 Object.isSealed(obj) 메서드로 알 수 있다.

```javascript
const object1 = {
    property1 : 42,
};
    
Object.seal(object1);
object1.property1 = 33;
console.log(object1.property1); // 기대값 : 33

delete object1.property1;   // Cannot delete when sealed;
console.log(object1.property1); // 기대값 : 33
```
  
- Object.preventExtensions()
  - 새로운 속성이 기존 객체에 추가되는 것을 방지한다.
  - 새로운 속성의 추가(X), 기존 속성의 삭제(O), 기존 값의 변경(O)
  - 확장 금지 여부는 Object.isExtensible(obj)로 알 수 있다.

```javascript
const object1 = {};

Object.preventExtensions(object1);

try {
	Object.defineProperty(object1, 'property1', {
		value : 42,
    });
} catch(e) {
  console.log(e);   // 기대값 : TypeError: Cannot define property property1, object is not extensible
}

///////////////////

// Object.preventExtensions는 확장 불가된 객체를 반환한다.
var obj = {};
var obj2 = Object.preventExtensions(obj);
obj === obj2; // true
```

