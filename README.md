### Hexlet tests and linter status:
[![Actions Status](https://github.com/NowUKnow1/java-project-71/workflows/hexlet-check/badge.svg)](https://github.com/NowUKnow1/java-project-71/actions)
[![.github/workflows/main.yml](https://github.com/NowUKnow1/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/NowUKnow1/java-project-71/actions/workflows/main.yml)
<a href="https://codeclimate.com/github/NowUKnow1/java-project-71/maintainability"><img src="https://api.codeclimate.com/v1/badges/9f7c0e91b893e78f6275/maintainability" /></a>
<a href="https://codeclimate.com/github/NowUKnow1/java-project-71/test_coverage"><img src="https://api.codeclimate.com/v1/badges/9f7c0e91b893e78f6275/test_coverage" /></a>

Данная утилита сравнивает два объекта и возвращает результат сравнения в виде объекта. Ключами результирующего объекта будут все ключи из двух входящих объектов, а значением строка с описанием отличий: added, deleted, changed или unchanged.

Расшифровка значений:

added — ключ отсутствовал в первом объекте, но был добавлен во второй
deleted — ключ был в первом объекте, но отсутствует во втором
changed — ключ присутствовал и в первом и во втором объектах, но значения отличаются
unchanged — ключ присутствовал и в первом и во втором объектах с одинаковыми значениями

К  утилите подлючена библиотека Cli. Настроенные для использования флаги - h и V. Пример использования:

Usage: gendiff [-hV]
  -h, --help      Show this help message and exit.
  -V, --version   Print version information and exit.
