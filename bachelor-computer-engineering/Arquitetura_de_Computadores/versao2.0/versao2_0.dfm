object Form1: TForm1
  Left = 106
  Top = 145
  BorderIcons = [biSystemMenu]
  BorderStyle = bsDialog
  Caption = 'Figuras'
  ClientHeight = 493
  ClientWidth = 876
  Color = clBtnFace
  Constraints.MaxHeight = 527
  Constraints.MaxWidth = 884
  Constraints.MinHeight = 520
  Constraints.MinWidth = 884
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 13
  object Image1: TImage
    Left = 228
    Top = 6
    Width = 640
    Height = 480
    Anchors = [akTop, akRight, akBottom]
    Stretch = True
  end
  object Panel1: TPanel
    Left = 6
    Top = 6
    Width = 214
    Height = 481
    Anchors = [akLeft, akTop, akRight, akBottom]
    TabOrder = 0
    object GroupBox1: TGroupBox
      Left = 24
      Top = 48
      Width = 169
      Height = 73
      Caption = 'Ponto 1'
      TabOrder = 2
      object Label1: TLabel
        Left = 24
        Top = 20
        Width = 13
        Height = 13
        Caption = 'X1'
      end
      object Label2: TLabel
        Left = 24
        Top = 44
        Width = 13
        Height = 13
        Caption = 'Y1'
      end
      object EdX1: TEdit
        Left = 88
        Top = 16
        Width = 57
        Height = 21
        TabOrder = 0
      end
      object EdY1: TEdit
        Left = 88
        Top = 40
        Width = 57
        Height = 21
        TabOrder = 1
      end
    end
    object Desenha: TBitBtn
      Left = 72
      Top = 448
      Width = 81
      Height = 25
      Caption = 'Desenha'
      Default = True
      TabOrder = 0
      OnClick = DesenhaClick
    end
    object Figura: TComboBox
      Left = 24
      Top = 16
      Width = 169
      Height = 21
      ItemHeight = 13
      TabOrder = 1
      Text = 'Rectangulo'
      OnChange = FiguraChange
      Items.Strings = (
        'Rectangulo'
        'Triangulo'
        'Losango'
        'Paralelogramo'
        'Trapézio'
        'Divisa')
    end
    object GroupBox2: TGroupBox
      Left = 24
      Top = 128
      Width = 169
      Height = 73
      Caption = 'Ponto 2'
      TabOrder = 3
      object Label3: TLabel
        Left = 24
        Top = 20
        Width = 13
        Height = 13
        Caption = 'X2'
      end
      object Label4: TLabel
        Left = 24
        Top = 44
        Width = 13
        Height = 13
        Caption = 'Y2'
      end
      object EdX2: TEdit
        Left = 89
        Top = 16
        Width = 57
        Height = 21
        TabOrder = 0
      end
      object EdY2: TEdit
        Left = 89
        Top = 40
        Width = 57
        Height = 21
        TabOrder = 1
      end
    end
    object RadioGroup1: TRadioGroup
      Left = 24
      Top = 267
      Width = 169
      Height = 57
      Caption = 'Estilo'
      TabOrder = 4
    end
    object RadioButton1: TRadioButton
      Left = 56
      Top = 282
      Width = 113
      Height = 17
      Caption = 'Desenha por Cima'
      Checked = True
      TabOrder = 5
      TabStop = True
    end
    object RadioButton2: TRadioButton
      Left = 56
      Top = 299
      Width = 113
      Height = 17
      Caption = 'Apaga Imagem'
      TabOrder = 6
    end
    object GroupBox3: TGroupBox
      Left = 24
      Top = 208
      Width = 169
      Height = 48
      Caption = 'Ponto 3'
      TabOrder = 7
      Visible = False
      object Label5: TLabel
        Left = 24
        Top = 20
        Width = 13
        Height = 13
        Caption = 'X3'
      end
      object EdX3: TEdit
        Left = 89
        Top = 16
        Width = 57
        Height = 21
        TabOrder = 0
      end
    end
    object Mensagens: TGroupBox
      Left = 24
      Top = 336
      Width = 169
      Height = 97
      Caption = 'Mensagens'
      TabOrder = 8
      object Mensagem: TLabel
        Left = 8
        Top = 16
        Width = 150
        Height = 30
        Caption = 'qwe'
        Constraints.MaxHeight = 80
        Constraints.MaxWidth = 150
        Constraints.MinHeight = 30
        Constraints.MinWidth = 150
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'Courier New'
        Font.Style = []
        ParentFont = False
      end
    end
    object BitBtn1: TBitBtn
      Left = 151
      Top = 296
      Width = 22
      Height = 22
      TabOrder = 9
      OnClick = BitBtn1Click
      Glyph.Data = {
        DE010000424DDE01000000000000760000002800000024000000120000000100
        0400000000006801000000000000000000001000000000000000000000000000
        80000080000000808000800000008000800080800000C0C0C000808080000000
        FF0000FF000000FFFF00FF000000FF00FF00FFFF0000FFFFFF00333333333333
        333333333333333333333333000033338833333333333333333F333333333333
        0000333911833333983333333388F333333F3333000033391118333911833333
        38F38F333F88F33300003339111183911118333338F338F3F8338F3300003333
        911118111118333338F3338F833338F3000033333911111111833333338F3338
        3333F8330000333333911111183333333338F333333F83330000333333311111
        8333333333338F3333383333000033333339111183333333333338F333833333
        00003333339111118333333333333833338F3333000033333911181118333333
        33338333338F333300003333911183911183333333383338F338F33300003333
        9118333911183333338F33838F338F33000033333913333391113333338FF833
        38F338F300003333333333333919333333388333338FFF830000333333333333
        3333333333333333333888330000333333333333333333333333333333333333
        0000}
      NumGlyphs = 2
    end
  end
end
