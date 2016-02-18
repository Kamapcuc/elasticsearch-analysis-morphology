A fork of [elasticsearch-analysis-morphology](https://github.com/imotov/elasticsearch-analysis-morphology) that adds two new token filters:
- russian_word_form
- english_word_form
For example those analyzer leave only nouns in nominative case:

```
PUT test
{
   "settings": {
      "index": {
         "analysis": {
            "analyzer": {
               "noun": {
                  "type": "custom",
                  "char_filter": [],
                  "tokenizer": "standard",
                  "filter": [
                     "noun_filter"
                  ]
               }
            },
            "filter": {
               "noun_filter": {
                  "type": "russian_word_form",
                  "grammemas": [
                     "С",
                     "им"
                  ]
               }
            }
         }
      }
   }
}
```