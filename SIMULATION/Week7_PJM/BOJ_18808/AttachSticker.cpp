#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int N, M,K;
vector< vector< vector< vector<bool> > > >stickers; // [stickerIndex(몇번째 스티커인지)][stickerDir(0,90,180,270)][row][col]
vector<vector<bool>> notebookMap;

bool isSticks(int startRow, int startCol, int StickerDir,int StickerIndex){
  int stickerRowSize = stickers[StickerIndex][StickerDir].size();
  int stickerColSize = stickers[StickerIndex][StickerDir][0].size();
  if(startRow +stickerRowSize >N || startCol +stickerColSize>M){
    return false;
  }
  for(int stickRow =0; stickRow<stickerRowSize;stickRow++){
    for(int stickCol=0;stickCol<stickerColSize;stickCol++){
      if(stickers[StickerIndex][StickerDir][stickRow][stickCol]==1 && notebookMap[startRow+stickRow][startCol+stickCol]==1){
        return false;
      }
    }
  }
  for(int stickRow =0; stickRow<stickerRowSize;stickRow++){
    for(int stickCol=0;stickCol<stickerColSize;stickCol++){
      if(stickers[StickerIndex][StickerDir][stickRow][stickCol]==1){
        notebookMap[startRow+stickRow][startCol+stickCol] = true;
      }
    }
  }
  return true;
}

int solve(){
  int curDir;
  int curIndex;
  int curRow,curCol;
  for(curIndex=0;curIndex<K;curIndex++){
    curRow=0;
    curCol=0;
    curDir = 0;
    while(curDir<4 && !isSticks(curRow,curCol,curDir,curIndex)){
      int stickerRowSize = stickers[curIndex][curDir].size();
      int stickerColSize = stickers[curIndex][curDir][0].size();
      curCol++;
      if(curCol+stickerColSize>M){
        curCol=0;
        curRow++;
      }
      if(curRow+stickerRowSize>N){
        curRow=0;
        curCol=0;
        curDir++;
      }
    }
  }
  int sum =0;
  for(int row =0; row<N;row++){
    for(int col =0; col<M;col++){
      if(notebookMap[row][col]==true){
        sum++;
      }
    }
  }
  return sum;
}

int main(void){
  ios_base :: sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int stickerRow, stickerCol;
  int tem;
  cin >> N >> M >> K;

  notebookMap = vector< vector<bool> >(N, vector<bool>(M));
  for(int i=0;i<K;i++){
    cin >> stickerRow >> stickerCol;
    vector< vector< vector<bool> > > stickertmp;
    vector< vector<bool> > sticker1(stickerRow, vector<bool>(stickerCol));
    vector< vector<bool> > sticker2(stickerCol, vector<bool>(stickerRow));
    vector< vector<bool> > sticker3(stickerRow, vector<bool>(stickerCol));
    vector< vector<bool> > sticker4(stickerCol, vector<bool>(stickerRow));
    for(int row =0;row<stickerRow;row++){
      for(int col =0; col<stickerCol;col++){
        cin >> tem;
        if(tem ==1){
          sticker1[row][col] = true;
          sticker2[col][stickerRow-1-row] = true;
          sticker3[stickerRow-1-row][stickerCol-1-col] = true;
          sticker4[stickerCol-1-col][row] = true;
        }
      }
    }
    stickertmp.push_back(sticker1);
    stickertmp.push_back(sticker2);
    stickertmp.push_back(sticker3);
    stickertmp.push_back(sticker4);
    stickers.push_back(stickertmp);
  }

  cout<< solve();
  
}