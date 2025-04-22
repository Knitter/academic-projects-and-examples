object HotelGest: THotelGest
  Left = 360
  Top = 113
  Caption = 'HotelGest'
  ClientHeight = 561
  ClientWidth = 632
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  FormStyle = fsMDIForm
  Menu = Menu
  OldCreateOrder = False
  Position = poDesigned
  OnClose = FormClose
  OnCloseQuery = FormCloseQuery
  OnCreate = FormCreate
  PixelsPerInch = 96
  TextHeight = 13
  object StatusBar1: TStatusBar
    Left = 0
    Top = 542
    Width = 632
    Height = 19
    AutoHint = True
    Panels = <
      item
        Width = 400
      end
      item
        Alignment = taCenter
        Text = 'Desligado'
        Width = 100
      end
      item
        Alignment = taCenter
        Text = 'Data'
        Width = 100
      end
      item
        Bevel = pbNone
        Width = 50
      end>
    ExplicitTop = 522
  end
  object Menu: TMainMenu
    Left = 6
    Top = 3
    object MenuHotelGest: TMenuItem
      Caption = '&HotelGest'
      object MenuItemLogin: TMenuItem
        Caption = '&Login...'
        OnClick = Login
      end
      object MenuItemLogout: TMenuItem
        Caption = 'Logout'
        Enabled = False
        OnClick = MenuItemLogoutClick
      end
      object N1: TMenuItem
        Caption = '-'
      end
      object MenuItemOptions: TMenuItem
        Caption = '&Op'#231#245'es...'
        OnClick = MenuItemOptionsClick
      end
      object N2: TMenuItem
        Caption = '-'
      end
      object MenuItemExit: TMenuItem
        Caption = '&Sair'
        OnClick = MenuItemExitClick
      end
    end
    object MenuData: TMenuItem
      Caption = '&Registos'
      object MenuItemBookings: TMenuItem
        Caption = '&Entradas'
        OnClick = MenuItemBookingsClick
      end
      object MenuItemReservation: TMenuItem
        Caption = '&Reservas'
        OnClick = MenuItemReservationClick
      end
      object MenuItemCheckOut: TMenuItem
        Caption = '&Sa'#237'das'
        OnClick = MenuItemCheckOutClick
      end
      object N3: TMenuItem
        Caption = '-'
      end
      object MenuItemClients: TMenuItem
        Caption = 'Lista &Clientes'
        OnClick = MenuItemClientsClick
      end
      object MenuItemBlackList: TMenuItem
        Caption = 'Lista &Negra'
        OnClick = MenuItemBlackListClick
      end
      object MenuItemRegistered: TMenuItem
        Caption = 'Lista &Utentes'
        OnClick = MenuItemRegisteredClick
      end
      object N4: TMenuItem
        Caption = '-'
      end
      object MenuItemSales: TMenuItem
        Caption = 'Vendas'
        OnClick = MenuItemSalesClick
      end
    end
    object MenuManagement: TMenuItem
      Caption = 'A&dministra'#231#227'o'
      object MenuItemMenuProdServ: TMenuItem
        Caption = '&Produtos e Servi'#231'os'
        OnClick = MenuItemMenuProdServClick
      end
      object MenuItemMenuRooms: TMenuItem
        Caption = '&Quartos'
        OnClick = MenuItemMenuRoomsClick
      end
      object N8: TMenuItem
        Caption = '-'
      end
      object MenuItemDiscount: TMenuItem
        Caption = '&Descontos'
        OnClick = MenuItemDiscountClick
      end
      object MenuItemExtras: TMenuItem
        Caption = '&Extras'
        OnClick = MenuItemExtrasClick
      end
      object MenuItemTax: TMenuItem
        Caption = '&IVA'
        OnClick = MenuItemTaxClick
      end
      object N6: TMenuItem
        Caption = '-'
      end
      object MenuItemUsers: TMenuItem
        Caption = '&Utilizadores'
        OnClick = MenuItemUsersClick
      end
      object MenuItemLog: TMenuItem
        Caption = '&Ver Registo de Ac'#231#245'es'
        OnClick = MenuItemLogClick
      end
    end
    object MenuWindow: TMenuItem
      Caption = '&Janela'
      Enabled = False
    end
    object MenuHelp: TMenuItem
      Caption = '&Ajuda'
      object MenuItemAbout: TMenuItem
        Caption = '&Sobre'
        OnClick = MenuItemAboutClick
      end
    end
  end
  object DateUpdater: TTimer
    Interval = 3600000
    Left = 45
    Top = 3
  end
end
