# mushroom

--

# APIs

## Vote

### 투표들 가져오기
`GET`
/api/article/votes

### 투표 가져오기
`GET`
/api/article/vote/{id}

## 투표 등록하기

`POST`
/api/article/vote

## 댓글 등록하기

`POST`
/api/article/{articleId}/comment

## 투표 혹은 댓글 좋아요 혹은 취소 (스위치?)

`POST`
/api/article/{articleId}/like

## 투표 혹은 댓글 싫어요 혹은 취소 (스위치?)

`POST`
/api/article/{articleId}/dislike

```
수정...?
```