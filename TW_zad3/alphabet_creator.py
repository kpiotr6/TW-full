from typing import Dict,Tuple,List
from common import RelationGraph


# Funkcja pomocnicza przekształcająca krotkę na string.
def t2s(t: Tuple):
  return ','.join([str(i) for i in t])

# Zwraca krotkę składającą się z listy symboli (będącej jednocześnie słowem)
# oraz objekt RelationGraph = Dict[str,List[str]], ten graf relacji jest skierowany (by uprościć zapis),
# a krawędzie biegną od sybmboli wcześniejszych do późniejszych w zbiorze słów. Aby graf był 
# w pełni poprawny pod względem teorii, krawędzie powinny być nieskierowane (tzn. relacja symetryczna).

def create_alphabet(matrix_size: int) -> Tuple[List[str],RelationGraph]:
  n = matrix_size
  alphabet = []
  alphabet_tuples = []
  graph = dict()
  for i in range(1,n+1):
    for j in range(i+1,n+1):
      tmp = ('A',i,j)
      alphabet_tuples.append(tmp)
      alphabet.append(t2s(tmp))
      for k in range(i,n+2):
        tmp = ('B',i,k,j)
        alphabet_tuples.append(tmp)
        alphabet.append(t2s(tmp))
        tmp = ('C',i,k,j)
        alphabet_tuples.append(tmp)
        alphabet.append(t2s(tmp))
  for i,s in enumerate(alphabet_tuples):
    connections = []
    for j in range(i+1,len(alphabet_tuples)):
      tup = alphabet_tuples[j] 
      match s[0]:
        case 'A':
          if tup[0] == 'B' and tup[1] == s[1] and tup[3] == s[2]:
            connections.append(t2s(tup))
        case 'B':
          if tup[0] == 'C' and tup[1:] == s[1:]:
            connections.append(t2s(tup))
        case 'C':
          if tup[0] == 'C' and tup[1] == s[1]+1 and tup[2:] == s[2:]:
            connections.append(t2s(tup))
          if tup[0] == 'B' and tup[1] == s[1]+1 and tup[2] == s[2] and tup[3] == s[3]+1:
            connections.append(t2s(tup))
          if tup[0] == 'A':
            if tup[1] == s[2] == s[3] or (tup[1] == s[2] and tup[2] == s[3]):
              connections.append(t2s(tup))
    graph[t2s(s)] = connections
  return alphabet,graph


